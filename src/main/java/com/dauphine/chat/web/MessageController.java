package com.dauphine.chat.web;

import com.dauphine.chat.data.MessageRepository;
import com.dauphine.chat.domain.Message;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by marti on 08/01/2017.
 */
@RestController
@RequestMapping(value = MessageController.URI_ROOT, produces = MediaType.APPLICATION_JSON_VALUE)
public class MessageController {

    protected static final String URI_ROOT = "/chat/{room}";

    private static final Logger LOGGER = LogManager.getLogger(MessageController.class);

    @Autowired
    private MessageRepository messageRepository;


    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Message>> findRooms(@PathVariable("room") final String room) {
        return new ResponseEntity<>(messageRepository.findByRoom(room, sortByDateAsc()), HttpStatus.FOUND);
    }


    private Sort sortByDateAsc() {
        return new Sort(Sort.Direction.ASC, "date");
    }

}
