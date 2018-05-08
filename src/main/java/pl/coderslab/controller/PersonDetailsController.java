package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;

import pl.coderslab.entity.PersonDetails;

import java.util.Random;

@Controller
public class PersonDetailsController {


    @Autowired
    PersonDetailsDao personDetailsDao;

    @Autowired
    PersonDao personDao;

    @GetMapping("/personDetails/add")
    @ResponseBody
    public String addPersonDetails(){
        Random rand = new Random();
        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName( "personDetails_"+rand.nextInt(100) );

        personDetailsDao.save(personDetails);

        return "Added "+personDetails.getFirstName();
    }


    @GetMapping("/personDetails/update")
    @ResponseBody
    public String updatePersonDetails(){

        PersonDetails personDetails = new PersonDetails();
        personDetails.setId(5);
        personDetails.setFirstName("Johnny");

        personDetailsDao.update(personDetails);
        return "PersonDetails updated on id: " + personDetails.getId();
    }

    @GetMapping("/personDetails/find/{id}")
    @ResponseBody
    public PersonDetails findById(@PathVariable("id") Long id) {

        PersonDetails personDetails = personDetailsDao.findById(id);
        return personDetails;
    }

    @GetMapping("/personDetails/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable ("id") Long id) {

        personDetailsDao.delete(id);
        return "PersonDetails deleted on id: " + id;
    }


}


