package mamabolotgub.springframework.springjpaintro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

import mamabolotgub.springframework.springjpaintro.entity.Book;
import mamabolotgub.springframework.springjpaintro.repositories.BookRepository;

@DataJpaTest
public class SpringbookJpaTestSplice {

    @Autowired
    BookRepository bookRepository;

    @Commit  /* this helps to persist the book created in the first method.
              in the course they encourage one to use order method but
               in this version of springboot it doesn't seem to be important. */
    @Test
    void testJpaSplice() {
        long countBefore = bookRepository.count();
        bookRepository.save(new Book("maths Lit","8520321546", "van Schaik"));
        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }

    @Test
    void testJpaSpliceTransactions() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(1);
    }
}
