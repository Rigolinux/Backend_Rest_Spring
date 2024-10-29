package dev.rigolinux.commerce.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    Optional<Run> findById(Integer id) {
        return runs.stream().filter(run -> run.id() == id).findFirst();
    }

    Run save(Run run) {
        runs.add(run);
        return run;
    }


    Optional<Run> deleteRunById(int id) {

        Optional<Run> runToDeleteOptional = runs.stream()
                .filter(r -> r.id() == id)
                .findFirst();


        if (runToDeleteOptional.isEmpty()) {
            return Optional.empty();
        }


        Run runToDelete = runToDeleteOptional.get();
        runs.remove(runToDelete);
        return Optional.of(runToDelete);
    }

    Optional<Run> update(Run run, int id) {

        Optional<Run> runToUpdateOptional = runs.stream()
                .filter(r -> r.id() == id)
                .findFirst();


        if (runToUpdateOptional.isEmpty()) {
            return Optional.empty();
        }


        Run runToUpdate = runToUpdateOptional.get();

        Run updatedRun = new Run(
                runToUpdate.id(),
                run.title(),
                run.startedOn(),
                run.completedOn(),
                run.miles(),
                run.location()
        );


        runs.remove(runToUpdate);
        runs.add(updatedRun);


        return Optional.of(updatedRun);
    }



}

