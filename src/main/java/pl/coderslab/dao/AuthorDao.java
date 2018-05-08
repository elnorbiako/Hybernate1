package pl.coderslab.dao;

import org.springframework.beans.factory.annotation.Autowired;
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
public class AuthorDao {

    @PersistenceContext
    EntityManager em;

    @Autowired
    BookDao bookDao;

    public void save(Author author) {
        em.persist(author);
    }

    public void update(Author author) {
        em.merge(author);
    }

    public Author findById(Long id) {
        return em.find(Author.class, id);
    }

    public void delete(Long id){
        Author author = findById(id);
//        //testowo próba wywalenia z booka
//        List<Book> books = bookDao.listAll();
//
//        for (Book book : books) {
//            List<Author> authors = book.getAuthors();
//            if (authors.contains(author) ) {
//                authors.remove(author.getId() );
//            }
//        }

        em.remove( em.contains(author) ? author : em.merge(author) );
    }

    public List<Author> listAll() {
        Query query = em.createQuery("SELECT b FROM Author b");
        List<Author> authors = query.getResultList();
        return authors;
    }


}


