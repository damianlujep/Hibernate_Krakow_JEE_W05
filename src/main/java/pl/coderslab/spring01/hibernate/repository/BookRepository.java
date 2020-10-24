package pl.coderslab.spring01.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01.hibernate.controller.entity.Author;
import pl.coderslab.spring01.hibernate.controller.entity.Book;
import pl.coderslab.spring01.hibernate.controller.entity.Category;
import pl.coderslab.spring01.hibernate.controller.entity.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long>{

    Book findOneByTitle(String title);
    List<Book> findAllByCategoryId (long  categoryId);
    List<Book> findAllByCategoryName (String name);
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByAuthors (Author author);
    List<Book> findAllByPublisher(Publisher publisher);
    List<Book> findAllByRating(int rating);
    Book findFirstByCategoryOrderByTitleAsc (Category category);
}
