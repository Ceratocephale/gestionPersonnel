package com.example.gestionmembrepersonnel.repos;

import com.example.gestionmembrepersonnel.models.entity.Person;
import com.example.gestionmembrepersonnel.models.entity.Person.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("SELECT p FROM Person p ORDER BY p.firstName")
    List<Person> getAllInAlphabeticOrderFromFirstName();
}