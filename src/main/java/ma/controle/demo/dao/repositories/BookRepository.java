package ma.controle.demo.dao.repositories;

import ma.controle.demo.dao.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitreAndPublisher(String titre, String publisher);
}