package com.rubayet.demo.api;

import com.rubayet.demo.model.Person;
import com.rubayet.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public int addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/{id}")
    public Person getPersonByID(@PathVariable("id") UUID id) {
        return personService.getPersonByID(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public int deletePersonByID(@PathVariable("id") UUID id) {
        return personService.deletePersonById(id);
    }

    @PutMapping("/{id}")
    public int updatePersonByID(@PathVariable("id") UUID id, @RequestBody Person person) {
        return personService.updatePersonById(id, person);
    }
}
