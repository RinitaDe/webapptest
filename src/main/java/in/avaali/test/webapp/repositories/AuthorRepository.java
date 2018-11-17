package in.avaali.test.webapp.repositories;

import in.avaali.test.webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
