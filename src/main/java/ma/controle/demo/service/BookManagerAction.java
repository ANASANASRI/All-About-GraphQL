package ma.controle.demo.service;

import ma.controle.demo.dao.repositories.BookRepository;
import ma.controle.demo.dtos.BookDTO;
import ma.controle.demo.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookManagerAction {
    private static BookRepository bookRepository;
    private static BookMapper bookMapper;

    @Autowired
    public void BookManager(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public static BookDTO getBookById(Long id) {
        return bookMapper.fromBookToBookDto(bookRepository.findById(id).orElse(null));
    }

    public static BookDTO saveBook(BookDTO bookDTO) {
        if (bookExists(bookDTO.getTitre(), bookDTO.getPublisher())) {
            throw new RuntimeException("deja existe");
        }
        return bookMapper.fromBookToBookDto(bookRepository.save(bookMapper.fromBookDtoToBook(bookDTO)));
    }

    private  boolean bookExists(String titre, String publisher) {
        //return bookRepository.findByTitreAndPublisher(titre, publisher).get(0);
        return null;
    }
}
