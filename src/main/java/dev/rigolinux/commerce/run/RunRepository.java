package dev.rigolinux.commerce.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() { return runs; }

    @PostConstruct
    public void init() {
        runs.add(new Run(1,"Morning Run", LocalDateTime.now(),LocalDateTime.now().plusHours(1), 5,Location.INDOOR));
        runs.add(new Run(2,"Evening Run", LocalDateTime.now(),LocalDateTime.now().plusHours(2), 10,Location.OUTDOOR));
        runs.add(new Run(3,"Night Run", LocalDateTime.now(),LocalDateTime.now().plusHours(3), 15,Location.INDOOR));
        runs.add(new Run(4,"Morning Run", LocalDateTime.now(),LocalDateTime.now().plusHours(1), 5,Location.INDOOR));
    }
}
