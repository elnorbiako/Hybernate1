package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager em;

    public void save(Book book) {
        em.persist(book);
    }

    public void update(Book book) {
        em.merge(book);
    }

    public Book findById(Long id) {
        return em.find(Book.class, id);
    }

    public void delete(Long id){
        Book book = findById(id);
        em.remove( em.contains(book) ? book : em.merge(book) );
    }

    public List<Book> getRatingList(int rating) {
        Query queryp = em.createQuery("SELECT b FROM Book b where rating >:rating");
        queryp.setParameter("rating", rating);
        List<Book> booksp = queryp.getResultList();
        return booksp;
    }

    public List<Book> listAll(){
        Query query = em.createQuery("SELECT b FROM Book b");
        List<Book> books = query.getResultList();
        return books;
    }


}
