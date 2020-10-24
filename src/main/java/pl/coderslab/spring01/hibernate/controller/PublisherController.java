package pl.coderslab.spring01.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01.hibernate.controller.entity.Book;
import pl.coderslab.spring01.hibernate.controller.entity.Publisher;
import pl.coderslab.spring01.hibernate.dao.PublisherDao;
import pl.coderslab.spring01.hibernate.repository.PublisherRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/publisher", produces = "text/html; charset=UTF-8")
public class PublisherController {
    private final PublisherDao publisherDao;
    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherController(PublisherDao publisherDao, PublisherRepository publisherRepository) {
        this.publisherDao = publisherDao;
        this.publisherRepository = publisherRepository;
    }

    @GetMapping("/add")
    public String addPublisher(Model m) {
        m.addAttribute("publisher", new Publisher());
        return "/publisher/add-form";
    }

    @PostMapping("/add")
    public String addPublisherAndShowList(@ModelAttribute("publisher") @Valid Publisher publisher, BindingResult result, Model m){
        if (result.hasErrors()){
            return "publisher/add-form";
        }

        this.publisherRepository.save(publisher);
//        m.addAttribute("author", author);
        return "redirect:list";

        //TODO
    }

    @GetMapping("/get/{id}")
    @Transactional
    public String getPublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.readBooks(publisher);
        return publisher.toString();
    }

    @GetMapping("/books/{id}")
    @Transactional
    public String getAllBooksByPublisherId(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.readBooks(publisher);

        List<Book> books = publisher.getBooks();
        return books.toString();
    }

    @GetMapping("/update/{id}/{publisherName}")
    public String updatePublisher(@PathVariable long id, @PathVariable String publisherName) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(publisherName);
        publisherDao.update(publisher);
        return publisher.toString();
    }

    @GetMapping("/delete/{id}")
    public String deletePublisher(@PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "deleted";
    }

    @GetMapping("/list")
    public String getAll(){
        return  "/publisher/list-publishers";
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers(){
       return this.publisherRepository.findAll();
    }

    @GetMapping("/findPublisherByNip/{nipNumber}")
    @ResponseBody
    public String findPublisherByNip (@PathVariable String nipNumber){
        Publisher byNip = this.publisherRepository.findByNip(nipNumber);
        return byNip.toString();
    }

    @GetMapping("findPublisherByRegon/{regonNumber}")
    @ResponseBody
    public String findPublisherByRegon (@PathVariable String regonNumber){
        Publisher byRegon = this.publisherRepository.findByRegon(regonNumber);
        return byRegon.toString();
    }


}
