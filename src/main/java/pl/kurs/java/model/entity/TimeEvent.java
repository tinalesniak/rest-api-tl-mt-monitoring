package pl.kurs.java.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TimeEvent {
    private LocalDateTime dateTime;
    private String method;
    private Long executionTimeMillis;
}
