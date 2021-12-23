package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final Repository repository;
    private final Producer producer;

    public Controller(Repository repository, Producer producer) {
        this.repository = repository;
        this.producer = producer;
    }

    @PutMapping("/add")
    public String addNew(){
        Entity e = new Entity();
        e.setName("aaa");
        repository.save(e);
        return "saved";
    }

    @GetMapping("/get")
    public Iterable<Entity> getAll(){
        return repository.findAll();
    }

    @PutMapping("/put")
    public String addNewQueue(){
        producer.send();
        return "sent";
    }
}
