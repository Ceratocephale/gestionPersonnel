package Service.impl;

import Service.PersonService;
import exception.NoPersonFoundException;
import models.dto.PersonDTO;
import models.entity.Person.*;
import models.entity.Person;
import models.form.PersonForm;
import repos.PersonRepository;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<PersonDTO> getAll() {
       return personRepository.findAll().stream()
               .map(PersonDTO::from)
               .toList();
    }

    public PersonDTO getOne(int id){
        return personRepository.findById(id)
                .map(PersonDTO::from).orElseThrow(NoPersonFoundException::new);
    }

    public PersonDTO delete(int id){
        PersonDTO retour = getOne(id);
        personRepository.deleteById(id);

        return retour;
    }

    public PersonDTO add(PersonForm form){
        Person person = form.toEntity();

        return PersonDTO.from(personRepository.save(person));

    }

    @Override
    public List<PersonDTO> getAllFromStatus(Status status) {
        return personRepository.getAllFromStatus(status)
                .stream()
                .map(PersonDTO::from)
                .toList();
    }

    @Override
    public List<PersonDTO> getAllAlphabetical() {
        return personRepository.getAllAlphabetical()
                .stream()
                .map(PersonDTO::from)
                .toList();
    }

    @Override
    public PersonDTO update(int id, PersonForm form) {
        Person person = form.toEntity();
        person.setId(id);
        delete(id);
        return PersonDTO.from(personRepository.save(person));

    }

}
