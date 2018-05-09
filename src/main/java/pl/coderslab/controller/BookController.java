package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.validation.Valid;

import java.util.List;
import java.util.Random;

@Controller
public class BookController {

    @Autowired
    BookDao bookDao;

    @Autowired
    PublisherDao publisherDao;

    @Autowired
    AuthorDao authorDao;

    @GetMapping("/book/add/{publisher_id}")
    @ResponseBody
    public String addBook(@PathVariable Long publisher_id){

        Publisher publisher = publisherDao.findById( publisher_id );

        Random rand = new Random();

        Book book = new Book();
        book.setTitle("Harry Potter part "+rand.nextInt(10));

        book.setPublisher( publisher );

        bookDao.save(book);
        return "Book saved on id: "+book.getId();
    }

    @GetMapping("/book/{id}")
    @ResponseBody
    public String getBook(@PathVariable Long id){
        Book book = bookDao.findById(id);
        return book.getTitle();
    }

    @GetMapping("/book/addForm")
    public String bookForm (Model model) {
        model.addAttribute("book", new Book() );
        return "BookForm";
    }

    @PostMapping("/book/addForm")
    public String bookForm(@Valid @ModelAttribute Book book, BindingResult result) {
        if (result.hasErrors()) {
            return  "BookForm";
        }
        bookDao.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String listAll(Model model) {

        List<Book> books =  bookDao.listAll();
        model.addAttribute("books", books);
        return "BookList";
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

    @ModelAttribute("publishers")
    public List<Publisher> checkPublishers() {
        return publisherDao.listAll();

    }

    @ModelAttribute("authors")
    public List<Author> checkAuthors() {
        return authorDao.listAll();
    }
}