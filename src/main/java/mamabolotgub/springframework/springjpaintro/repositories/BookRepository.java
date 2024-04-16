package mamabolotgub.springframework.springjpaintro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mamabolotgub.springframework.springjpaintro.entity.Book;

/**
 * @Author Tshepo Mahudu
 */
public interface BookRepository extends JpaRepository<Book, Long> {

}
