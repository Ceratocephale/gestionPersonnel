package repos;

import models.entity.Person;
import models.entity.Person.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> getAllFromStatus(Status status);

    List<Person> getAllAlphabetical();
}