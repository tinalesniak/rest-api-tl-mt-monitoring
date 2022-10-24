package pl.kurs.java.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import pl.kurs.java.model.entity.ExecutionTimeRegistry;
import pl.kurs.java.model.entity.TimeEvent;
import pl.kurs.java.repository.TimeExecutionRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class TimeExecutionEventListener {
    private final TimeExecutionRepository timeExecutionRepository;
    private final ObjectMapper objectMapper;

    @JmsListener(destination = "log-time-queue")
    @SneakyThrows
    public void subscribeExecutionTime(String logTimeEventJson) {
        log.info("Consuming event: {}", logTimeEventJson);
        TimeEvent timeEvent = objectMapper.readValue(logTimeEventJson, TimeEvent.class);
        timeExecutionRepository.saveAndFlush(new ExecutionTimeRegistry(timeEvent.getDateTime(), timeEvent.getMethod(), timeEvent.getExecutionTimeMillis()));
    }
}
