package com.dauphine.chat.web;

import com.dauphine.chat.domain.User;
import com.dauphine.chat.service.UserService;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by marti on 13/12/2016.
 */
@RestController
@RequestMapping(value = UserController.URI_ROOT, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    static final String URI_ROOT = "/";
    private static final String URI_USER = "users";
    private static final String URI_REGISTER = "register";


    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = URI_USER, method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findUser(@RequestBody final String mail) {
        User user = userService.findByMail(mail);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        LOGGER.log(Level.INFO, String.format("Find user with user %s", user.toString()));
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @RequestMapping(value = URI_REGISTER, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody final User user) {
        if (userService.findUser(user) == null) {
            userService.create(user);
            LOGGER.log(Level.INFO, String.format("New user created %s", user.toString()));
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        LOGGER.log(Level.INFO, String.format("User %s already exist", user.toString()));
        return new ResponseEntity<>(HttpStatus.IM_USED);
    }

    @RequestMapping(value = URI_USER, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(@RequestBody final User user) {
        userService.update(user);
        LOGGER.log(Level.INFO, String.format("User updated %s", user.toString()));
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = URI_USER, method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteUser(@RequestBody final User user) {
        userService.disableUser(user.getMail());
        LOGGER.log(Level.INFO, String.format("User deleted %s", user.toString()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
