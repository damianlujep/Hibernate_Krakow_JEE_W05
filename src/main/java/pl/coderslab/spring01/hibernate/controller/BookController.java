package pl.coderslab.spring01.hibernate.controller;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01.hibernate.controller.entity.Author;
import pl.coderslab.spring01.hibernate.controller.entity.Book;
import pl.coderslab.spring01.hibernate.controller.entity.Publisher;
import pl.coderslab.spring01.hibernate.dao.AuthorDao;
import pl.coderslab.spring01.hibernate.dao.BookDao;
import pl.coderslab.spring01.hibernate.dao.PublisherDao;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value = "/book" , produces = "text/html; charset=UTF-8")
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    @Autowired
    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/add")
    public String addBook() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setRating(5);
        bookDao.saveBook(book);
        return "Id dodanej książki to:"
                + book.getId();
    }

    @GetMapping("/addbookwp")
    public String addBookWithPublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherDao.savePublisher(publisher);

        Book book = new Book();
        book.setTitle("Thinking in C++");
        book.setDescription("Ciekawa pozycja");
        book.setPublisher(publisher);
        bookDao.saveBook(book);

        return "Added book id=" + book.getId() + "with publisher id=" + publisher.getId();
    }

    @GetMapping("/addbookath")
    public String addBookWithAuthors(){
        List<Author> authorList = new ArrayList<>();
        Author author1 = authorDao.findById(1);
        Author author2 = authorDao.findById(3);
        authorList.add(author1);
        authorList.add(author2);

        Book book = new Book();
        book.setTitle("Spring Famework");
        book.setDescription("Książka o springu");
        book.setAuthors(authorList);
        bookDao.saveBook(book);

        return "Added book id=" + book.getId() + "with authors id= " + author1.getId() + " and " + author2.getId() ;
    }

    @GetMapping("/addanotherwp")
    public String addAnotherBookWithPublisher(){
        Publisher publisher = publisherDao.findById(1L);

        Book book = new Book();
        book.setTitle("Thinking in SQL");
        book.setDescription("Jeszcze pozycja");
        book.setPublisher(publisher);

        bookDao.saveBook(book);

        return "Added book id= " + book.getId() + "with publisher id=" + publisher.getId();
    }

    @GetMapping("/get/{id}")
    @Transactional
    public String getBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        Hibernate.initialize(book.getPublisher());
        Hibernate.initialize(book.getAuthors());
        return book.toString();
    }

    @GetMapping("/update/{id}/{title}")
    public String updateBook(@PathVariable long id, @PathVariable String title ) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book.toString();
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "deleted";
    }

    @GetMapping("/all")
    @Transactional
    public String getAll(){
        List<Book> books = bookDao.findAll();
        for (Book b: books){
            Hibernate.initialize(b.getPublisher());
            Hibernate.initialize(b.getAuthors());
        }

        return books.toString();
    }

    @GetMapping("/byminrating/{minRating}")
    @Transactional
    public String getAllByRating(@PathVariable int minRating){
        List<Book> books = bookDao.findByRatingGT(minRating);
        for (Book b: books){
            Hibernate.initialize(b.getPublisher());
            Hibernate.initialize(b.getAuthors());
        }
        return books.toString();
    }

    @GetMapping("/allwithpublsh")
    @Transactional
    public String getAllWithPublisher(){
        List<Book> books = bookDao.findAllWithPublisher();
        for (Book b: books){
            Hibernate.initialize(b.getPublisher());
            Hibernate.initialize(b.getAuthors());
        }
        return books.toString();
    }

    @GetMapping("/allwithpublsh/{publisherId}")
    @Transactional
    public String getAllWithGivenPublisher(@PathVariable long publisherId){
        List<Book> books = bookDao.findAllWithPublisherId(publisherId);
        for (Book b: books){
            Hibernate.initialize(b.getPublisher());
            Hibernate.initialize(b.getAuthors());
        }
        return books.toString();
    }

    @GetMapping("/allwithauthor/{authorId}")
    @Transactional
    public String getAllWithAuthorId(@PathVariable long authorId){
        List<Book> books = bookDao.findAllWitAuthorId(authorId);
        for (Book b: books){
            Hibernate.initialize(b.getPublisher());
            Hibernate.initialize(b.getAuthors());
        }
        return books.toString();
    }


}
