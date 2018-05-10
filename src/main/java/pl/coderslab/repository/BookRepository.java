package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitleLikeIgnoreCase(String title);

    @Query("Select b from Book b where b.title like :title")
    List<Book> findBooksByTitlePart(String title);

    List<Book> findAllByAuthors(List <Author> authors);

    List<Book> findAllByAuthorsId(Long authorsId);

    List<Book> findAllByPublisherId(Long publisherId);

    @Query("Select b from Book b Join b.authors a Where a = :authors")
    List<Book> findAllBooksForAuthor(@Param("author") List<Author> authors);

    List<Book> findAllByRatingEquals(int rating);

    Book findFirstByAuthorsIdOrderByTitle(Long authorsId);

    //Zadania na zaawansowane zapytania


    @Query("select b from Book b where b.rating between ratingA and ratingB ")
    List<Book> findByRatingBetween(@Param("ratingA")int ratingA,@Param("ratingB") int ratingB);

    @Query ("select b from Book b join b.publisher p Where p.id = publisherId ")
    List<Book> findAllByPublisher(@Param ("publisherId") Long publisherId);

    //@Query ("select b from Book b where b.authors like author order by b.title ")
    //test
    @Query(value="SELECT * FROM books WHERE author = ?1 order by title desc LIMIT 1", nativeQuery = true)
    Book findTheOne (Long authorId);


}
