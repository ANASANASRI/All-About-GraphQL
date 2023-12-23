package ma.controle.demo.service;

import ma.controle.demo.dao.repositories.BookRepository;
import ma.controle.demo.dtos.BookDTO;
import ma.controle.demo.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//interface
@Service
public class BookManager {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookManager(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }


    public BookDTO getBookById(Long id) {
        return bookMapper.fromBookToBookDto(bookRepository.findById(id).orElse(null));
    }

    public BookDTO saveBook(BookDTO bookDTO) {
        return bookMapper.fromBookToBookDto(bookRepository.save(bookMapper.fromBookDtoToBook(bookDTO)));
    }
}
