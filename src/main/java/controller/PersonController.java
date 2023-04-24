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

        return retour;
    }

    @GetMapping("/all/a")
    public List<PersonDTO> getAllAlphabetical(){
        List<PersonDTO> retour = service.getAllAlphabetical();

        return retour;
    }

    @GetMapping("/all/s={status}")
    public List<PersonDTO> getAllFromStatus(@PathVariable Status status){
        List<PersonDTO> retour = service.getAllFromStatus(status);

        return retour;
    }

    @GetMapping("/{id:[0-9]+}")
    public PersonDTO getOne(@PathVariable int id){
        PersonDTO retour = service.getOne(id);

        return retour;
    }

    @DeleteMapping("/{id:[0-9]+}")
    public PersonDTO delete(@PathVariable int id){
        PersonDTO retour = service.delete(id);
        sender.send(retour);

        return retour;
    }

    @PostMapping("/add")
    public PersonDTO create(@RequestBody @Valid PersonForm form){
        PersonDTO retour = service.add(form);
        sender.send(retour);

        return retour;
    }

    @PatchMapping("/{id:[0-9]+}/update")
    public PersonDTO update(@PathVariable int id, @RequestBody @Valid PersonForm form){
        PersonDTO retour = service.update(id, form);
        sender.send(retour);

        return retour;
    }
}
