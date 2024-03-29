package com.dauphine.chat.domain;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.web.socket.WebSocketMessage;

/**
 * Created by marti on 10/12/2016.
 */
public class ChatMessage implements WebSocketMessage {

        private String message;
        private String username;
        private LocalDateTime date;
        private DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("d MMMM, yyyy, HH:mm:ss");


        public ChatMessage() {
            this.date = LocalDateTime.now();
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(final String message) {
            this.message = message;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(final String username) {
            this.username = username;
        }

        public String getDateTime(){
            return date.toString(dateTimeFormatter);
        }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "message='" + message + '\'' +
                ", username='" + username + '\'' +
                ", datetimeFormat=" + this.getDateTime() +
                '}';
    }

    @Override
    public Object getPayload() {
        return this.toString();
    }

    @Override
    public int getPayloadLength() {
        return this.toString().length();
    }

    @Override
    public boolean isLast() {
        return false;
    }
}
