package com.example.gestionmembrepersonnel.controller;

import com.example.gestionmembrepersonnel.Service.PersonService;
import com.example.gestionmembrepersonnel.models.dto.PersonDTO;
import com.example.gestionmembrepersonnel.models.entity.Person;
import jakarta.validation.Valid;
import com.example.gestionmembrepersonnel.models.form.PersonForm;
import com.example.gestionmembrepersonnel.mqs.Sender;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService service;
    private final Sender sender;

    public PersonController(PersonService service, Sender sender) {
        this.service = service;
        this.sender = sender;
    }

    @GetMapping("/all")
    public List<PersonDTO> getAll() {
        return service.getAll().
                stream()
                .map(PersonDTO::from)
                .toList();
    }

    @GetMapping("/all/a")
    public List<PersonDTO> getAllAlphabetical() {

        return service.getAllAlphabetical()
                .stream()
                .map(PersonDTO::from)
                .toList();
    }

    @GetMapping("/all/s={status}")
    public List<PersonDTO> getAllFromStatus(@PathVariable Person.Status status) {

        return service.getAllFromStatus(status)
                .stream()
                .map(PersonDTO::from)
                .toList();
    }

    @GetMapping("/{id:[0-9]+}")
    public PersonDTO getOne(@PathVariable int id) {

        return PersonDTO.from(service.getOne(id));
    }

    @DeleteMapping("/{id:[0-9]+}")
    public PersonDTO delete(@PathVariable int id) {
        Person person = service.getOne(id);
        sender.send(person);
        return PersonDTO.from(person);
    }

    @PostMapping("/add")
    public PersonDTO create(@RequestBody @Valid PersonForm form) {
        Person retour = service.add(form);
        sender.send(retour);

        return PersonDTO.from(retour);
    }

    @PatchMapping("/{id:[0-9]+}/update")
    public PersonDTO update(@PathVariable int id, @RequestBody @Valid PersonForm form) {
        Person retour = service.update(id, form);
        sender.send(retour);

        return PersonDTO.from(retour);
    }
}
