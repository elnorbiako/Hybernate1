package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.dto.PersonDto;
import pl.coderslab.entity.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class PersonController {
    
    @Autowired
    PersonDetailsDao personDetailsDao;
    
    @Autowired
    PersonDao personDao;

    @GetMapping("/person/add")
    @ResponseBody
    public String addPerson(){
        Random rand = new Random();
        Person person = new Person();
        person.setLogin( "person_"+rand.nextInt(100) );

        personDao.save(person);

        return "Added "+person.getLogin();
    }


    @GetMapping("/person/update")
    @ResponseBody
    public String updatePerson(){

        Person person = new Person();
        person.setId(5);
        person.setLogin("John");

        personDao.update(person);
        return "Person updated on id: " + person.getId();
    }

    @GetMapping("/person/find/{id}")
    @ResponseBody
    public Person findById(@PathVariable("id") Long id) {

        Person person = personDao.findById(id);
        return person;
    }

    @GetMapping("/person/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable ("id") Long id) {

        personDao.delete(id);
        return "Person deleted on id: " + id;
    }


    @GetMapping("/person/form")
    public String addForm(Model model) {
        model.addAttribute("person", new PersonDto() );
        return "PersonForm";
    }

    @PostMapping("/person/form")
    @ResponseBody
    public String addForm(@ModelAttribute PersonDto person) {

        return person.toString();
    }

    @ModelAttribute("countryItems")
    public List<String> checkOptions() {
        String a[] = new String[] {"Poland", "Germany", "Slovakia", "Slovenia"};
        return Arrays.asList(a);
    }

    @ModelAttribute("programmingSkills")
    public List<String> checkProgrammingSkills() {
        String a[] = new String[] {"SQL", "spring", "HTML", "JS"};
        return Arrays.asList(a);
    }

    @ModelAttribute("hobbies")
    public List<String> checkHobbies() {
        String a[] = new String[] {"sport", "drinking", "being lazy", "eating"};
        return Arrays.asList(a);
    }
}
