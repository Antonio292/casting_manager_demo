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
            System.out.println("You enter incorrect  Participant Id!");
            log.warn("attempt to enter incorrect Participant id");
            //            throw new IllegalArgumentException("You enter incorrect Id!");
        } else {
            this.id = id;
            log.info("Participant id was added");
        }
    }

    public void setName(String name) {
        if ((name == null) || (name.isEmpty())) {
            System.out.println("You enter incorrect Participant Name!");
            log.warn("attempt to enter incorrect Participant Name");
            //            throw new IllegalArgumentException("You enter incorrect Name!");
        } else {
            this.name = name;
            log.info("Participant name was added");
        }
    }

    public void setStatus(String status) {
        if ((status == null) || (status.isEmpty())) {
            System.out.println("You enter incorrect Participant Status!");
            log.warn("attempt to enter incorrect Participant Status");
            //            throw new IllegalArgumentException("You enter incorrect Status!");
        } else {
            this.status = status;
            log.info("Participant status was added");
        }
    }

}