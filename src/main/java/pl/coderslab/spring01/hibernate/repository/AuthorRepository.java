package pl.coderslab.spring01.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01.hibernate.controller.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long>{

    Author findByEmail (String email);
    Author findByPesel (String peselNumber);
    List<Author> findAllByLastName (String lastName);

}
