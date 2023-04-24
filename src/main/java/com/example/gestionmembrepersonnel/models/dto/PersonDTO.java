package com.example.gestionmembrepersonnel.models.dto;


import com.example.gestionmembrepersonnel.models.entity.Person;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PersonDTO {

    private String lastname;
    private String firstname;
    private LocalDate birthdate;
    private String address;
    private Person.Sex sex;
    private String title;
    private Person.Status status;


    public static PersonDTO from(Person entity){
        if(entity == null)
            return null;

        return PersonDTO.builder()
                .lastname(entity.getLastName())
                .firstname(entity.getFirstName())
                .birthdate(entity.getBirthdate())
                .address(entity.getAddress())
                .sex(entity.getSex())
                .title(entity.getTitle())
                .status(entity.getStatus())
                .build();
    }

}
