//package pl.coderslab.repository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.*;
//import javax.transaction.Transactional;
//
//public class BookRepositoryImpl implements BookRepoCustom{
//
//    @PersistenceUnit
//    EntityManagerFactory emFactory;
//
//    public BookRepositoryImpl() {}
//
//    @Override
//    @Transactional
//    public void resetRating(int rating) {
//        EntityManager em = emFactory.createEntityManager();
//        em.joinTransaction();
//
//        Query q = em.createQuery("Update Book b set b.rating = :rating");
//        q.setParameter("rating", rating);
//        q.executeUpdate();
//
//        em.close();
//    }
//}
