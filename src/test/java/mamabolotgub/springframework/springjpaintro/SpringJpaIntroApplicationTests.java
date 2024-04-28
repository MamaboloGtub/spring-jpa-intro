package mamabolotgub.springframework.springjpaintro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mamabolotgub.springframework.springjpaintro.repositories.BookRepository;

@SpringBootTest
class SpringJpaIntroApplicationTests {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testBookRespository() {
        long count = bookRepository.count();
        assertThat(count).isGreaterThan(0);
    }

    @Test
    void contextLoads() {
    }

}
