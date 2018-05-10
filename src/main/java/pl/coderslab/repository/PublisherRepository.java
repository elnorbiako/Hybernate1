package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    Publisher findByNipLike(String nip);
    Publisher findByRegonLike(String regon);
}
