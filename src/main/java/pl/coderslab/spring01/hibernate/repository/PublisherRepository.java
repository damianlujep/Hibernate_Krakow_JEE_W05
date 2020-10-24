package pl.coderslab.spring01.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01.hibernate.controller.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher,Long>{

    Publisher findByNip (String nipNUmber);
    Publisher findByRegon (String regonNumber);





}
