package com.dauphine.chat.web;

import com.dauphine.chat.domain.ChatMessage;
import com.dauphine.chat.event.LoginEvent;
import com.dauphine.chat.event.ParticipantRepository;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Collection;


/**
 * Controller that handles WebSocket chat messages
 *
 * Created by marti on 10/12/2016.
 */
//@Controller
public class ChatController {
 /*

        @Autowired private ParticipantRepository participantRepository;

        //@Autowired private SimpMessagingTemplate simpMessagingTemplate;

        private static final Logger LOGGER = LogManager.getLogger(ChatController.class);


        @SubscribeMapping("/chat.participants")
        public Collection<LoginEvent> retrieveParticipants(){
            return participantRepository.getActiveSessions().values();
        }


        @MessageMapping("/chat.message")
        public ChatMessage filterMessage(@Payload final ChatMessage message, final Principal principal){
            message.setUsername(principal.getName());
            LOGGER.log(Level.INFO, String.format(" new message from %s %s", message.getUsername(), message));
            return message;
        }


        @MessageMapping("/chat.private.{username}")
        public void filterPrivateMessage(@Payload final ChatMessage message, @DestinationVariable("username") final String username, Principal principal){
            message.setUsername(principal.getName());
            LOGGER.log(Level.INFO,String.format("%s is sending a private message to %s (%s)", message.getUsername(), username, message.getMessage()));
            //simpMessagingTemplate.convertAndSend("/user/" + username + "/exchange/amq.direct/chat.message", message);
        }
*/

}
