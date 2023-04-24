package com.example.gestionmembrepersonnel.Service;

import com.example.gestionmembrepersonnel.models.entity.Person;
import com.example.gestionmembrepersonnel.models.form.PersonForm;

import java.util.List;

public interface PersonService {
    List<Person> getAll();

    Person getOne(int id);

    Person delete(int id);

    Person add(PersonForm form);

    List<Person> getAllFromStatus(Person.Status status);
    List<Person> getAllAlphabetical();

    Person update(int id, PersonForm form);
}
