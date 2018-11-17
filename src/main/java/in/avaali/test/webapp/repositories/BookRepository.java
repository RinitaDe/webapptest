package in.avaali.test.webapp.repositories;

import in.avaali.test.webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
