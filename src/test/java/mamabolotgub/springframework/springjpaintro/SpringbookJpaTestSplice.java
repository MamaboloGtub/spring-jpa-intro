package mamabolotgub.springframework.springjpaintro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import mamabolotgub.springframework.springjpaintro.entity.Book;
import mamabolotgub.springframework.springjpaintro.repositories.BookRepository;

@DataJpaTest
public class SpringbookJpaTestSplice {

    @Autowired
    BookRepository bookRepository;
    @Test
    void testJpaSplice() {
        long countBefore = bookRepository.count();
        bookRepository.save(new Book("maths Lit","8520321546", "van Schaik"));
        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }
}
