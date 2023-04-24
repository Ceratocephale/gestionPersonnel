package com.example.gestionmembrepersonnel.Service.impl;

import com.example.gestionmembrepersonnel.Service.PersonService;
import com.example.gestionmembrepersonnel.exception.NoPersonFoundException;
import com.example.gestionmembrepersonnel.models.entity.Person;
import com.example.gestionmembrepersonnel.models.entity.Person.*;
import com.example.gestionmembrepersonnel.models.form.PersonForm;
import com.example.gestionmembrepersonnel.repos.PersonRepository;
import org.springframework.stereotype.Service;

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
        List<Person> persons = getAll();
        return persons.stream().filter(p->p.getStatus() == status).toList();

    }

    @Override
    public List<Person> getAllAlphabetical() {
        return personRepository.getAllInAlphabeticOrderFromFirstName();
    }

    @Override
    public Person update(int id, PersonForm form) {
        Person person = form.toEntity();
        person.setId(id);
        personRepository.delete(personRepository.findById(id).orElseThrow(NoPersonFoundException::new));
        return personRepository.save(person);
    }



}
