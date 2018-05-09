package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Publisher;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@Controller
public class PublisherController {

    @Autowired
    PublisherDao publisherDao;

    @GetMapping("/publisher/add")
    @ResponseBody
    public String addPublisher(){
        Random rand = new Random();
        Publisher publisher = new Publisher();
        publisher.setName( "publisher_"+rand.nextInt(100) );

        publisherDao.save(publisher);

        return "Added "+publisher.getName();
    }


    @GetMapping("/publisher/update")
    @ResponseBody
    public String updatePublisher(){

        Publisher publisher = new Publisher();
        publisher.setId(5);
        publisher.setName("Bukrower");

        publisherDao.update(publisher);
        return "Publisher updated on id: " + publisher.getId();
    }

    @GetMapping("/publisher/find/{id}")
    @ResponseBody
    public Publisher findById(@PathVariable("id") Long id) {

        Publisher publisher = publisherDao.findById(id);
        return publisher;
    }

    @GetMapping("/publisher/addForm")
    public String publisherForm (Model model) {
        model.addAttribute("publisher", new Publisher() );
        return "PublisherForm";
    }

    @PostMapping("/publisher/addForm")
    public String publisherForm(@Valid @ModelAttribute Publisher publisher, BindingResult result) {
        if (result.hasErrors()) {
            return "PublisherForm";
        }
        publisherDao.save(publisher);
        return "redirect:/publishers";
    }

    @GetMapping("/publishers")
    public String listAll(Model model) {

        List<Publisher> publishers = publisherDao.listAll();
        model.addAttribute("publishers", publishers);
        return "PublisherList";
    }

    @GetMapping("publisher/delete/{id}")
    public String delete(@PathVariable Long id) {

        publisherDao.delete(id);
        return "redirect:/publishers";
    }

    @GetMapping("publisher/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        Publisher publisher = publisherDao.findById(id);
        model.addAttribute("publisher", publisher);
        return "PublisherEdit";
    }

    @PostMapping("publisher/edit/{id}")
    public String edit(@ModelAttribute Publisher publisher) {
        publisherDao.update(publisher);
        return "redirect:/publishers";
    }

}


