package app.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
public class StatusUpdateInfo {
    private String id;
    private String newStatus;

}
