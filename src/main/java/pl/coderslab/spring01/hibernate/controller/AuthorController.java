package pl.coderslab.spring01.hibernate.controller;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01.hibernate.controller.entity.Author;
import pl.coderslab.spring01.hibernate.dao.AuthorDao;
import pl.coderslab.spring01.hibernate.repository.AuthorRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private final AuthorDao authorDao;
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorDao authorDao, AuthorRepository authorRepository) {
        this.authorDao = authorDao;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/add")
    public String addAuthor(Model m) {
        m.addAttribute("author", new Author());
        return "author/add-form";
    }

    @PostMapping("/add")
    public String addAuthorAndShowList(@ModelAttribute("author") @Valid Author author, BindingResult result, Model m){
        if (result.hasErrors()){
            return "author/add-form";
        }

        this.authorRepository.save(author);
        m.addAttribute("author", author);
        return "redirect:list";
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

    @GetMapping("/list")
    public String getAll(){
        return "/author/list-authors";
    }

    @ModelAttribute("authors")
    public List<Author> getAllAuthors(){
        return this.authorRepository.findAll();
    }

    @GetMapping("/findByEmail/{email}")
    @ResponseBody
    public String findByEmail(@PathVariable String email){
        Author byEmail = this.authorRepository.findByEmail(email);
        return byEmail.toString();
    }

    @GetMapping("/findByPesel/{peselNumber}")
    @ResponseBody
    public String findByPesel(@PathVariable String peselNumber){
        Author byPesel = this.authorRepository.findByPesel(peselNumber);
        return byPesel.toString();

    }

    @GetMapping("/findAllByLastName/{lastName}")
    @ResponseBody
    public String findAllByLastName(@PathVariable String lastName){
        List<Author> allByLastName = this.authorRepository.findAllByLastName(lastName);
        return allByLastName.toString();

    }

}
