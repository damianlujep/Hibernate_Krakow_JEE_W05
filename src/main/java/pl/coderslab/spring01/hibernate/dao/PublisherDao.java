package pl.coderslab.spring01.hibernate.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.spring01.hibernate.controller.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    EntityManager entityManager;

    public void savePublisher(Publisher publisher) {
        entityManager.persist(publisher);
    }

    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void readBooks(Publisher p) {
        Hibernate.initialize(p.getBooks());
    }

    public void update(Publisher publisher) {
        entityManager.merge(publisher);
    }

    public void delete(Publisher publisher) {
        entityManager.remove(entityManager.contains(publisher) ?
                publisher : entityManager.merge(publisher));
    }

    public List<Publisher> getAll(){
        Query query = entityManager.createQuery("SELECT p FROM Publisher p");
        return query.getResultList();
    }
}
