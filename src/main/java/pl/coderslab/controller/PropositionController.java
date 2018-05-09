package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PropositionController {

    @Autowired
    BookDao bookDao;

    @GetMapping("/proposition/addForm")
    public String propositionForm (Model model) {
        model.addAttribute("book", new Book() );
        return "PropositionForm";
    }

    @PostMapping("/proposition/addForm")
    public String propositionForm(@Valid @ModelAttribute Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "PropositionForm";
        }
        bookDao.save(book);
        return "redirect:/propositions";
    }

    @GetMapping("/propositions")
    public String listAll(Model model) {

        List<Book> books =  bookDao.listAll();
        model.addAttribute("books", books);
        return "PropositionList";
    }

    @GetMapping("book/delete/{id}")
    public String delete(@PathVariable Long id) {

        bookDao.delete(id);
        return "redirect:/books";
    }


    @GetMapping("book/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "BookEdit";
    }

    @PostMapping("book/edit/{id}")
    public String edit(@ModelAttribute Book book) {
        bookDao.update(book);
        return "redirect:/books";

    }
}
