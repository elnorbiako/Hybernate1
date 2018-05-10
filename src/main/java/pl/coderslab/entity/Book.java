package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.interfaces.ValidationGroupProposition;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min =5, groups = {ValidationGroupProposition.class})
    @NotNull(groups = {Default.class, ValidationGroupProposition.class})
    private String title;

    @NotEmpty(groups = {ValidationGroupProposition.class})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Author> authors = new ArrayList<>();

    @Min(value =1, groups = {ValidationGroupProposition.class})
    @Max(value = 10, groups = {ValidationGroupProposition.class})
    private int rating;

    @NotNull(groups = {ValidationGroupProposition.class})
    @ManyToOne(fetch = FetchType.EAGER)
    private Publisher publisher;

    @Size(max=600, groups = {ValidationGroupProposition.class})
    @Column(columnDefinition = "TEXT")
    @NotNull(groups = {Default.class, ValidationGroupProposition.class})
    private String description;
    // to be continued - slajd 41

    @Min(value =1, groups = {ValidationGroupProposition.class})
    private int pages;

    private boolean proposition;


    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isProposition() {
        return proposition;
    }

    public void setProposition(boolean proposition) {
        this.proposition = proposition;
    }
}
