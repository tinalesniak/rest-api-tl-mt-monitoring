package pl.kurs.java.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ExecutionTimeRegistry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime dateTime;
    private String method;
    private Long executionTimeMillis;

    public ExecutionTimeRegistry(LocalDateTime dateTime, String method, Long executionTimeMillis) {
        this.dateTime = dateTime;
        this.method = method;
        this.executionTimeMillis = executionTimeMillis;
    }
}
