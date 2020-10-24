package pl.coderslab.spring01.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01.hibernate.controller.entity.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}
