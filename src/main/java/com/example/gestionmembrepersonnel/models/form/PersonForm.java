package com.example.gestionmembrepersonnel.models.form;

import com.example.gestionmembrepersonnel.models.entity.Person;

import java.time.LocalDate;

public class PersonForm {

    private String lastname;
    private String firstname;
    private LocalDate birthdate;
    private String address;
    private Person.Sex sex;
    private String title;
    private Person.Status status;

    public Person toEntity(){
        Person person = new Person();
        person.setFirstName(firstname);
        person.setLastName(lastname);
        person.setBirthdate(birthdate);
        person.setAddress(address);
        person.setSex(sex);
        person.setTitle(title);
        person.setStatus(status);

        return person;

    }
}
