package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Set;

@Controller
public class ValidationController {

    @Autowired
    Validator validator;

    @GetMapping("/validate")
    public String validateBook(Model model) {

        Book book = new Book();
        book.setTitle("test");
        book.setDescription("hello");
        book.setPages(0);

        Set<ConstraintViolation<Book>> valid = validator.validate(book);

//        StringBuilder errorString = new StringBuilder();
//        errorString.append("<p>Errors: ");
//
//        if(!valid.isEmpty() ) {
//
//            for(ConstraintViolation<Book> error : valid) {
//                errorString.append( error.getPropertyPath() + " :: " + error.getMessage() + "<hr/>" );
//            }
//        }
//
//        errorString.append("</p>");
//
//        model.addAttribute("errorString", errorString);

        model.addAttribute("valid", valid);

        return "ErrorView";
    }


    @GetMapping("/validate/author")
    @ResponseBody
    public String validateAuthor(Model model) {

        Author author = new Author();
        author.setFirstName("Jan");
        author.setLastName("Sobieski");
        author.setBirthDate(LocalDate.now().minusYears(10));

        Set<ConstraintViolation<Author>> valid = validator.validate(author);

        StringBuilder errorString = new StringBuilder();
        errorString.append("<p>Errors: ");

        if(!valid.isEmpty() ) {

            for(ConstraintViolation<Author> error : valid) {
                errorString.append( error.getPropertyPath() + " :: " + error.getMessage() + "<hr/>" );
            }
        }

        errorString.append("</p>");
        return errorString.toString();

    }
}
