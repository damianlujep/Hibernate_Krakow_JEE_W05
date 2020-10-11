package pl.coderslab.spring01.hibernate.controller;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01.hibernate.controller.entity.Author;
import pl.coderslab.spring01.hibernate.dao.AuthorDao;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/author")
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/add")
    public String addAuthor() {
        Author author = new Author();
        author.setFirstName("Author name");
        author.setLastName("Author lastname");
        authorDao.saveAuthor(author);
        return "Id dodanej autora to:"
                + author.getId();
    }

    @GetMapping("/get/{id}")
    @Transactional
    public String getAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        Hibernate.initialize(author.getBooks());
        return author.toString();
    }

    @GetMapping("/update/{id}/{firstName}/{lastName}")
    public String updateAuthor(@PathVariable long id, @PathVariable String firstName, String lastName ) {
        Author author = authorDao.findById(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.update(author);
        return author.toString();
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable long id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "deleted";
    }

    @GetMapping("/all")
    @Transactional
    public String getAll(){
        List<Author> all = authorDao.getAll();
        for (Author a : all){
            Hibernate.initialize(a.getBooks());
        }

        return all.toString();
    }

}
