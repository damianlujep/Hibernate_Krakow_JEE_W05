package pl.coderslab.spring01.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01.hibernate.controller.entity.Book;
import pl.coderslab.spring01.hibernate.controller.entity.Publisher;
import pl.coderslab.spring01.hibernate.dao.PublisherDao;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping(value = "/publisher", produces = "text/html; charset=UTF-8")
public class PublisherController {
    private final PublisherDao publisherDao;

    @Autowired
    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/add")
    @ResponseBody
    public String addPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Publisher name");
        publisherDao.savePublisher(publisher);
        return "Id dodanej publisher to:"
                + publisher.getId();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        return publisher.toString();
    }

    @GetMapping("/books/{id}")
    @ResponseBody
    @Transactional
    public String getAllBooksByPublisherId(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.readBooks(publisher);

        List<Book> books = publisher.getBooks();
        return books.toString();
    }

    @GetMapping("/update/{id}/{publisherName}")
    @ResponseBody
    public String updatePublisher(@PathVariable long id, @PathVariable String publisherName) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(publisherName);
        publisherDao.update(publisher);
        return publisher.toString();
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "deleted";
    }
}
