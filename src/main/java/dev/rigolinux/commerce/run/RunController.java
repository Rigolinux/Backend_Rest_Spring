package dev.rigolinux.commerce.run;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("/hello")
    String home(){
        return "Hello Runner";
    }


    @GetMapping()
    List<Run> runs() {
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run getRunById(@PathVariable Integer id) {

        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()) {
            throw new RunNotFoundException();
        }

        return run.get();
    }

    //Post new run with all fields from body and method post
    @PostMapping()
    Run newRun(@Valid @RequestBody Run newRun) {
        return runRepository.save(newRun);
    }


    @PutMapping("/{id}")
    Run replaceRun(@Valid @RequestBody Run newRun, @PathVariable Integer id) {
        Optional<Run> run = runRepository.update(newRun, id);
        if (run.isEmpty()) {
            throw new RunNotFoundException();

        }
        return run.get();
    }

    @DeleteMapping("/{id}")
    void deleteRun(@PathVariable Integer id) {
        var run = runRepository.deleteRunById(id);
        if (run.isEmpty()) {
            throw new RunNotFoundException();
        }
    }

}
