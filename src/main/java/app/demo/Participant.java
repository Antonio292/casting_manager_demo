package app.demo;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;




@ToString
@Slf4j
public class Participant {
    private String id;
    private String name;
    private String status;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        if ((id == null) || (id.isEmpty())) {
            System.out.println("You enter incorrect  Participant Id!");
//            throw new IllegalArgumentException("You enter incorrect Id!");
            log.warn("attempt to enter incorrect Participant id");
        } else {
            this.id = id;
            log.info("Participant id was added");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if ((name == null) || (name.isEmpty())) {
            System.out.println("You enter incorrect Participant Name!");
//            throw new IllegalArgumentException("You enter incorrect Name!");
            log.warn("attempt to enter incorrect Participant Name");
        } else {
            this.name = name;
            log.info("Participant name was added");
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if ((status == null) || (status.isEmpty())) {
            System.out.println("You enter incorrect Participant Status!");
//            throw new IllegalArgumentException("You enter incorrect Status!");
            log.warn("attempt to enter incorrect Participant Status");
        } else {
            this.status = status;
            log.info("Participant status was added");
        }
    }


}