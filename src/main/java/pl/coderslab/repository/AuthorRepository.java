package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByEmailLike (String email);
    Author findByPeselLike (String pesel);
    List<Author> findAllByLastNameLike (String lastName);

    @Query("select a from Author a where a.email like :emailPart")
    List<Author> findByEmailPart (@Param ("emailPart") String emailPart);

    @Query("select a from Author a where a.pesel like :peselPart")
    List<Author> findByPeselPart (@Param ("peselPart") String peselPart);

}
