package dev.rigolinux.commerce.run;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("/hello")
    String home(){
        return "Hello Runner";
    }


    @GetMapping("/runs")
    List<Run> runs() {
        return runRepository.findAll();
    }



}
