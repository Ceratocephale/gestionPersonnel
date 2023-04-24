package Service;

import models.dto.PersonDTO;
import models.entity.Person;
import models.entity.Person.*;
import models.form.PersonForm;

import java.util.List;

public interface PersonService {
    List<PersonDTO> getAll();

    PersonDTO getOne(int id);

    PersonDTO delete(int id);

    PersonDTO add(PersonForm form);

    List<PersonDTO> getAllFromStatus(Status status);
    List<PersonDTO> getAllAlphabetical();

    PersonDTO update(int id, PersonForm form);
}
