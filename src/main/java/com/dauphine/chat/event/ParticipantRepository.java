package com.dauphine.chat.event;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by marti on 10/12/2016.
 */
public class ParticipantRepository {

        private Map<String, LoginEvent> activeSessions = new ConcurrentHashMap<>();

        public void add(final String sessionId, LoginEvent event){
            activeSessions.put(sessionId, event);
        }

        public LoginEvent getParticipant(final String sessionId){
            return activeSessions.get(sessionId);
        }

        public void removeParticipant(final String sessionId){
            activeSessions.remove(sessionId);
        }

        public Map<String, LoginEvent> getActiveSessions(){
            return activeSessions;
        }

        public void setActiveSessions(Map<String, LoginEvent> activeSessions){
            this.activeSessions = activeSessions;
        }
}
