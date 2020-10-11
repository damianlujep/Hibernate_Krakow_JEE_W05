package pl.coderslab.spring01.hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01.hibernate.controller.entity.Person;
import pl.coderslab.spring01.hibernate.controller.entity.PersonDetails;
import pl.coderslab.spring01.hibernate.dao.PersonDao;
import pl.coderslab.spring01.hibernate.dao.PersonDetailsDao;

@Controller
@RequestMapping(value = "/personDetails", produces = "text/html; charset=UTF-8")
@ResponseBody
public class PersonDetailsController {
    private final PersonDao personDao;
    private final PersonDetailsDao personDetailsDao;

    public PersonDetailsController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }

    @GetMapping("/add")
    public String addPersonDetails(){
        PersonDetails details = new PersonDetails();
        details.setFirstName("Damian");
        details.setLastName("Ponce");
        details.setStreet("Primavera");
        details.setCity("Quito");
        details.setStreetNumber(25);

        Person person = personDao.findById(1L);
        details.setPerson(person);

        personDetailsDao.savePersonDetails(details);

        return"Details to person " + details.getFirstName() + " " + details.getLastName() +
                "have been added";

//        TODO
    }

    @GetMapping("/get/{id}")
    public String getPersonDetails (@PathVariable long id){
        PersonDetails details = personDetailsDao.findById(id);
        return details.toString();
    }

    @GetMapping("/update/{id}/{firstName}/{lastName}/{streetName}")
    public String updatePerson (@PathVariable long id, @PathVariable String firstName, @PathVariable String lastName, @PathVariable String streetName){
        PersonDetails details = personDetailsDao.findById(id);
        details.setFirstName(firstName);
        details.setLastName(lastName);
        details.setStreet(streetName);
        personDetailsDao.update(details);
        return details.toString();
    }

    @GetMapping("/delete/{id}")
    public String deletePersonDetails (@PathVariable long id){
        PersonDetails details = personDetailsDao.findById(id);
        personDetailsDao.delete(details);

        return "The person with name= " + details.getFirstName() +" has been deleted";
    }
}
