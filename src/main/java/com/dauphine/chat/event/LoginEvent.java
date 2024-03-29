package com.dauphine.chat.event;


import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * @author marti
 * @date 10/12/2016.
 */
public class LoginEvent {

       private String username;
       private LocalDateTime date;
       private DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("d MMMM, yyyy, HH:mm:ss");


        public LoginEvent(final String username) {
            this.username = username;
            this.date = LocalDateTime.now();

        }

        public String getUsername() {
            return username;
        }

        public void setUsername(final String username) {
            this.username = username;
        }

        public String getDate() { return date.toString(dateTimeFormatter); }

    @Override
    public String toString() {
        return "LoginEvent{" +
                "username='" + username + '\'' +
                ", date=" + this.getDate() +
                '}';
    }



}
