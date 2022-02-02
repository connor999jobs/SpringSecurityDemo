package com.gmail.konnor.SpringSecurityDemo.rest;

import com.gmail.konnor.SpringSecurityDemo.model.Developer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestController {

    private List<Developer> developers = Stream.of(
            new Developer( 1L, "Vadym", "Vadimovich"),
            new Developer(2L, "Oleg", "Olegovich"),
            new Developer(3L, "Andrey", "Yuriyovich")
            ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll(){
        return developers;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id){
        return developers.stream().filter( developer -> developer.getId().equals(id)).findFirst()
                .orElse(null);
    }


    @PostMapping
    public Developer create(@RequestBody Developer developer){
        this.developers.add(developer);
        return developer;
    }

    @DeleteMapping
    public void deleteById(@PathVariable Long id){
        this.developers.removeIf(developer -> developer.getId().equals(id));
    }
}
