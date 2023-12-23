package ma.controle.demo.mappers;

import ma.controle.demo.dao.entities.Book;
import ma.controle.demo.dtos.BookDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public BookDTO fromBookToBookDto(Book book) {
        return this.modelMapper.map(book, BookDTO.class);
    }

    public Book fromBookDtoToBook(BookDTO bookDto) {
        return this.modelMapper.map(bookDto, Book.class);
    }
}
