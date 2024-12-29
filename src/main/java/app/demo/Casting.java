package app.demo;


import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Getter
@ToString
public class Casting {
    private String id;
    private String name;
    private String description;
    private String location;
    private final Map<String, Participant> participants = new HashMap<>();


    public void setId(String id) {
        if ((id == null) || (id.isEmpty())) {
            System.out.println("Casting Id cannot be empty!");
//            throw new IllegalArgumentException("You enter incorrect Id!");
            log.warn("Casting Id cannot be empty");
        } else {
            this.id = id;
            log.info("Casting id was set");
        }
    }

    public void setName(String name) {
        if ((name == null) || (name.isEmpty())) {
            System.out.println("Casting Name cannot be empty!");
//            throw new IllegalArgumentException("You enter incorrect Name!");
            log.warn("Casting Name cannot be empty");
        } else {
            this.name = name;
            log.info("Casting name was set");
        }
    }

    public void setDescription(String description) {
        if ((description == null) || (description.isEmpty())) {
            System.out.println("Casting description cannot be empty!");
//            throw new IllegalArgumentException("You enter incorrect Name!");
            log.warn("Casting description cannot be empty");
        } else {
            this.description = description;
            log.info("Casting description was set");
        }
    }

    public void setLocation(String location) {
        if ((location == null) || (location.isEmpty())) {
            System.out.println("Casting location cannot be empty!");
//            throw new IllegalArgumentException("You enter incorrect Name!");
            log.warn("Casting location cannot be empty");
        } else {
            this.location = location;
            log.info("Casting location was set");
        }
    }

    public void registerParticipant(Participant participant) {
        this.participants.put(participant.getId(), participant);
        System.out.println("New participant was added");
        log.info("new participant was added");
    }

    public void updateStatus(StatusUpdateInfo statusUpdateInfo) {
        Participant foundParticipant = this.participants.get(statusUpdateInfo.getId());

        if(foundParticipant == null) {
            System.out.println("Participant was not found");
        } else {
            String newStatus = statusUpdateInfo.getNewStatus();
            if (newStatus != null && !newStatus.isEmpty()) {
                foundParticipant.setStatus(newStatus);
                System.out.println("Status was changed");
                log.info("Status was changed");
            }
        }
    }

    public void showParticipants() {
        for (Participant participant: this.participants.values()) {
            System.out.println(participant);
        }
    }
}
