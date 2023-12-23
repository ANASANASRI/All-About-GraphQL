package ma.controle.demo;

import ma.controle.demo.dao.entities.Book;
import ma.controle.demo.dao.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initializeData(BookRepository bookRepository) {

		return args -> {
			List<Book> books = Arrays.asList(
					Book.builder().titre("Titre1").publisher("Publisher1").build(),
					Book.builder().titre("Titre2").publisher("Publisher2").build(),
					Book.builder().titre("Titre3").publisher("Publisher3").build(),
					Book.builder().titre("Titre4").publisher("Publisher4").build()
			);

			bookRepository.saveAll(books);

			List<Book> savedBooks = bookRepository.findAll();
			System.out.println("Books: " + savedBooks);
		};
	}
}
