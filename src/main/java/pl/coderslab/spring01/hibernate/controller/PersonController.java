package pl.coderslab.spring01.hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01.hibernate.controller.entity.Person;
import pl.coderslab.spring01.hibernate.controller.entity.PersonDetails;
import pl.coderslab.spring01.hibernate.dao.PersonDao;
import pl.coderslab.spring01.hibernate.dao.PersonDetailsDao;

@Controller
@RequestMapping(value = "/person", produces = "text/html; charset=UTF-8")
@ResponseBody
public class PersonController {
    private final PersonDao personDao;
    private final PersonDetailsDao personDetailsDao;

    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }

    @GetMapping("/add")
    public String addPerson(){
        Person person = new Person();
        person.setLogin("damianlujep");
        person.setPassword("mypassword");
        person.setEmail("damianluje@gmail.com");

        personDao.savePerson(person);

        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("Damian");
        personDetails.setLastName("Luje");
        personDetails.setCity("Kraków");
        personDetails.setStreet("Francesco Nullo");
        personDetails.setStreetNumber(19);
        personDetails.setPerson(person);

        personDetailsDao.savePersonDetails(personDetails);

        person.setDetails(personDetails);


        return"A new Person with name " + personDetails.getFirstName() + " " + personDetails.getLastName() +
                "have been added";
    }

    @GetMapping("/get/{id}")
    public String getPerson (@PathVariable long id){
        Person person = personDao.findById(id);
        return person.toString();
    }

    @GetMapping("/update/{id}/{login}/{password}/{email}")
    public String updatePerson (@PathVariable long id, @PathVariable String login, @PathVariable String password, @PathVariable String email){
        Person person = personDao.findById(id);
        person.setEmail(email);
        person.setPassword(password);
        person.setLogin(login);
        personDao.update(person);
        return person.toString();
    }

    @GetMapping("/delete/{id}")
    public String deletePerson (@PathVariable long id){
        Person person = personDao.findById(id);
        personDao.delete(person);

        return "The person with login= " + person.getLogin() +" has been deleted";}
}
