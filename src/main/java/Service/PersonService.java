package Service;

import models.dto.PersonDTO;
import models.entity.Person;
import models.entity.Person.*;
import models.form.PersonForm;

import java.util.List;

public interface PersonService {
    List<Person> getAll();

    Person getOne(int id);

    Person delete(int id);

    Person add(PersonForm form);

    List<Person> getAllFromStatus(Status status);
    List<Person> getAllAlphabetical();

    Person update(int id, PersonForm form);
}
