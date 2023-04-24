package controller;

import Service.PersonService;
import jakarta.validation.Valid;
import models.dto.PersonDTO;
import models.entity.Person;
import models.entity.Person.*;
import models.form.PersonForm;
import mqs.Sender;
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
    public List<PersonDTO> getAll(){
        List<PersonDTO> retour = service.getAll();
        sender.send("select all person");

        return retour;
    }

    @GetMapping("/all/a")
    public List<PersonDTO> getAllAlphabetical(){
        List<PersonDTO> retour = service.getAllAlphabetical();
        sender.send("select all person in alphabetical order");

        return retour;
    }

    @GetMapping("/all/s={status}")
    public List<PersonDTO> getAllFromStatus(@PathVariable Status status){
        List<PersonDTO> retour = service.getAllFromStatus(status);
        sender.send("select all person from a status");

        return retour;
    }

    @GetMapping("/{id:[0-9]+}")
    public PersonDTO getOne(@PathVariable int id){
        PersonDTO retour = service.getOne(id);
        sender.send("selected person id " + id);

        return retour;
    }

    @DeleteMapping("/{id:[0-9]+}")
    public PersonDTO delete(@PathVariable int id){
        PersonDTO retour = service.delete(id);
        sender.send("deleted person id " + id);

        return retour;
    }

    @PostMapping("/add")
    public PersonDTO create(@RequestBody @Valid PersonForm form){
        PersonDTO retour = service.add(form);
        sender.send("created person");

        return retour;
    }

    @PatchMapping("/{id:[0-9]+}/update")
    public PersonDTO update(@RequestParam int id, @RequestBody @Valid PersonForm form){
        PersonDTO retour = service.update(id, form);
        sender.send("updated person");

        return retour;
    }
}
