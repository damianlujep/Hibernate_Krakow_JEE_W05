package pl.coderslab.spring01.hibernate.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01.hibernate.controller.entity.Book;
import pl.coderslab.spring01.hibernate.controller.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }

    public List<Book> findAll(){
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        return  query.getResultList();
    }

    public List<Book> findByRatingGT(int rating){
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.rating > :minRating");
        query.setParameter("minRating", rating);
        return  query.getResultList();
    }

    public List<Book> findAllWithPublisher(){
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher IS NOT NULL");
        return  query.getResultList();
    }

    public List<Book> findAllWithPublisherId (long publisherId){
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher.id = :publisherId");
        query.setParameter("publisherId", publisherId);
        return  query.getResultList();
    }

    public List<Book> findAllWitAuthorId (long authorId){
        Query query = entityManager.createQuery("SELECT b FROM Book b JOIN b.authors p WHERE p.id = :authorId");
        query.setParameter("authorId", authorId);
        return  query.getResultList();
    }
}

//    Uzupełnij klasę BookDao o metodę do pobierania listy wszystkich książek, które mają jakiegokolwiek wydawcę.

//    Uzupełnij klasę BookDao o metodę do pobierania listy wszystkich książek, które mają określonego w
//    parametrze wydawcę.

//    Uzupełnij klasę BookDao o metodę do pobierania listy wszystkich książek, które mają określonego w
//    parametrze autora.
