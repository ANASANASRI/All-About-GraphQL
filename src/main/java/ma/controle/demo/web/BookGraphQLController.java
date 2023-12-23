package ma.controle.demo.web;

import ma.controle.demo.dtos.BookDTO;
import ma.controle.demo.service.BookManagerAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookGraphQLController {
    @Autowired
    private BookManagerAction BookManagerAction;

    @QueryMapping
    public BookDTO getBookById(@Argument Long id) {
        return BookManagerAction.getBookById(id);
    }

    @MutationMapping
    public BookDTO saveBook(BookDTO bookDto) {
        return BookManagerAction.saveBook(bookDto);
    }
}
