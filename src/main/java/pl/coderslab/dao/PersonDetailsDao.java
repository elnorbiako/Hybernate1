package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class PersonDetailsDao {

    @PersistenceContext
    EntityManager em;

    public void save(PersonDetails personDetails) {
        em.persist(personDetails);
    }

    public void update(PersonDetails personDetails) {
        em.merge(personDetails);
    }

    public PersonDetails findById(Long id) {
        return em.find(PersonDetails.class, id);
    }

    public void delete(Long id){
        PersonDetails personDetails = findById(id);
        em.remove( em.contains(personDetails) ? personDetails : em.merge(personDetails) );
    }
}
