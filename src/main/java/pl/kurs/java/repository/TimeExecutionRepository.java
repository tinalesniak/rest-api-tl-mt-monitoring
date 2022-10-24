package pl.kurs.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.java.model.entity.ExecutionTimeRegistry;

public interface TimeExecutionRepository extends JpaRepository<ExecutionTimeRegistry, Integer> {
}
