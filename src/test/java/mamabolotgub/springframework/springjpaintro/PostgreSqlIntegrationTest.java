package mamabolotgub.springframework.springjpaintro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;

import mamabolotgub.springframework.springjpaintro.repositories.BookRepository;

/**
 * Tshepo M Mahudu
 */
@DataJpaTest
@ComponentScan(basePackages = {"mamabolotgub.springframework.springjpaintro.bootstrap"})
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestPropertySource(locations = "classpath:application.properties")
public class PostgreSqlIntegrationTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    void testPostgreSQL() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);
    }

}
