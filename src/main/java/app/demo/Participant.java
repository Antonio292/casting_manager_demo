package app.demo;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;




@Slf4j
@Getter
@ToString
public class Participant {
    private String id;
    private String name;
    private String status;


    public void setId(String id) {
        if ((id == null) || (id.isEmpty())) {
            System.out.println("Participant id cannot be empty");
            log.warn("Participant id cannot be empty");
            //            throw new IllegalArgumentException("You enter incorrect Id!");
        } else {
            this.id = id;
            log.info("Participant id was set");
        }
    }

    public void setName(String name) {
        if ((name == null) || (name.isEmpty())) {
            System.out.println("Participant name cannot be empty");
            log.warn("Participant name cannot be empty");
            //            throw new IllegalArgumentException("You enter incorrect Name!");
        } else {
            this.name = name;
            log.info("Participant name was set");
        }
    }

    public void setStatus(String status) {
        if ((status == null) || (status.isEmpty())) {
            System.out.println("Participant status cannot be empty");
            log.warn("Participant status cannot be empty");
            //            throw new IllegalArgumentException("You enter incorrect Status!");
        } else {
            this.status = status;
            log.info("Participant status was set");
        }
    }

}