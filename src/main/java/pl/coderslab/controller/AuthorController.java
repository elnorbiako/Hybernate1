package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthorController {


    @Autowired
    AuthorDao authorDao;

    @GetMapping("/author/add")
    @ResponseBody
    public String addAuthor(){

        Author author = new Author();
        author.setFirstName("J.K.");
        author.setLastName("Rowling");

        authorDao.save(author);
        return "Author saved on id: " + author.getId();
    }

    @GetMapping("/author/update")
    @ResponseBody
    public String updateAuthor(){

        Author author = new Author();
        author.setId(5);
        author.setFirstName("Harry Potter");
        author.setLastName("J.K.Rowling");

        authorDao.update(author);
        return "Author updated on id: " + author.getId();
    }

    @GetMapping("/author/find/{id}")
    @ResponseBody
    public Author findById(@PathVariable("id") Long id) {

        Author author = authorDao.findById(id);
        return author;
    }


    @GetMapping("/author/all")
    @ResponseBody
    public String all() {

        return authorDao.listAll().toString();

    }

    @GetMapping("/author/addForm")
    public String authorForm (Model model) {
        model.addAttribute("author", new Author() );
        return "AuthorForm";
    }

    @PostMapping("/author/addForm")
    public String authorForm(@Valid @ModelAttribute Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "AuthorForm";
        }
        authorDao.save(author);
        return "redirect:/author";
    }

    @GetMapping("/authors")
    public String listAll(Model model) {

        List<Author> authors = authorDao.listAll();
        model.addAttribute("authors", authors);
        return "AuthorList";
    }

    @GetMapping("author/delete/{id}")
    public String delete(@PathVariable Long id) {

        authorDao.delete(id);
        return "redirect:/authors";
    }

    @GetMapping("author/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        Author author = authorDao.findById(id);
        model.addAttribute("author", author);
        return "AuthorEdit";
    }

    @PostMapping("author/edit/{id}")
    public String edit(@ModelAttribute Author author) {
        authorDao.update(author);
        return "redirect:/authors";
    }

}
