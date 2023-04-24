package Service.impl;

import Service.PersonService;
import exception.NoPersonFoundException;
import models.entity.Person.*;
import models.entity.Person;
import models.form.PersonForm;
import org.springframework.stereotype.Service;
import repos.PersonRepository;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAll() {
       return personRepository.findAll();
    }

    public Person getOne(int id){
        return personRepository.findById(id).orElseThrow(NoPersonFoundException::new);
    }

    public Person delete(int id){
        Person person = personRepository.findById(id).orElseThrow(NoPersonFoundException::new);
        person.setActive(false);
        return personRepository.save(person);
    }

    public Person add(PersonForm form){
        Person person = form.toEntity();
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllFromStatus(Status status) {
        return personRepository.getAllFromStatus(status);
    }

    @Override
    public List<Person> getAllAlphabetical() {
        return personRepository.getAllAlphabetical();
    }

    @Override
    public Person update(int id, PersonForm form) {
        Person person = form.toEntity();
        person.setId(id);
        personRepository.delete(personRepository.findById(id).orElseThrow(NoPersonFoundException::new));
        return personRepository.save(person);
    }



}
