package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class PersonDao {

    @PersistenceContext
    EntityManager em;

    public void save(Person person) {
        em.persist(person);
    }

    public void update(Person person) {
        em.merge(person);
    }

    public Person findById(Long id) {
        return em.find(Person.class, id);
    }

    public void delete(Long id){
        Person person = findById(id);
        em.remove( em.contains(person) ? person : em.merge(person) );
    }
}
