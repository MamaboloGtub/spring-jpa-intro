package mamabolotgub.springframework.springjpaintro.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import mamabolotgub.springframework.springjpaintro.entity.Book;
import mamabolotgub.springframework.springjpaintro.repositories.BookRepository;

/**
 * @Author Tshepo Mahudu
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        bookRepository.deleteAll();

        Book book1 = new Book("The Concise", "9781788161565", "Profile Books");
        Book book2 = new Book("The Law", "4523167", "O'reilly");
        Book book3 = new Book("Biko", "12093", "Jacana");
        Book savedBook1 = bookRepository.save(book1);
        Book savedBook2 = bookRepository.save(book2);
        Book savedBook3 = bookRepository.save(book3);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
        });
    }

}
