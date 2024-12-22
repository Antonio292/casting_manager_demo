package app.demo;


import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Getter
@ToString
public class Casting {
    private String id;
    private String name;
    private String description;
    private String location;
    private List<Participant> participants = new ArrayList<>();


    public void setId(String id) {
        if ((id == null) || (id.isEmpty())) {
            System.out.println("You enter incorrect Casting Id!");
//            throw new IllegalArgumentException("You enter incorrect Id!");
            log.warn("attempt to enter incorrect Casting id");
        } else {
            this.id = id;
            log.info("Casting id was added");
        }
    }

    public void setName(String name) {
        if ((name == null) || (name.isEmpty())) {
            System.out.println("You enter incorrect Casting Name!");
//            throw new IllegalArgumentException("You enter incorrect Name!");
            log.warn("attempt to enter incorrect Casting Name");
        } else {
            this.name = name;
            log.info("Casting name was set");
        }
    }

    public void setDescription(String description) {
        if ((description == null) || (description.isEmpty())) {
            System.out.println("You enter incorrect Casting description!");
//            throw new IllegalArgumentException("You enter incorrect Name!");
            log.warn("attempt to enter incorrect Casting description");
        } else {
            this.description = description;
            log.info("Casting description was added");
        }
    }

    public void setLocation(String location) {
        if ((location == null) || (location.isEmpty())) {
            System.out.println("You enter incorrect Casting location!");
//            throw new IllegalArgumentException("You enter incorrect Name!");
            log.warn("attempt to enter incorrect Casting location");
        } else {
            this.location = location;
            log.info("Casting location was added");
        }
    }

    public void registerParticipant(Participant participant) {
        participants.add(participant);
        System.out.println("New participant was added");
        log.info("new participant was added");
    }

    public void updateStatus(StatusUpdateInfo status) {
        Participant participant1 = null;
        for (Participant participant : participants) {
            if (participant.getId().equals(id)) {
                participant1 = participant;
            }
        }
        if (status.getNewStatus() != null && !status.getNewStatus().isEmpty()) {
            participant1.setStatus(status.getNewStatus());
            System.out.println("Status was changed");
            log.info("status was changed");
        }
    }

    public static void showParticipants(Casting casting) {
        for (Participant participant: casting.getParticipants()) {
            System.out.println(participant);
        }
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }
}
