package in.avaali.test.webapp.bootstrap;

import in.avaali.test.webapp.model.Author;
import in.avaali.test.webapp.model.Book;
import in.avaali.test.webapp.model.Publisher;
import in.avaali.test.webapp.repositories.AuthorRepository;
import in.avaali.test.webapp.repositories.BookRepository;
import in.avaali.test.webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){
        Author eric = new Author("Eric","Evans");
        Publisher p1 = new Publisher();
        p1.setName("Test");
        Book ddd = new Book ("Domain Driven Desing","1234",p1);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        publisherRepository.save(p1);
        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author rod = new Author("Rod","Johnson");

        Book noEJB = new Book ("J2EE Development without EJB","123458",p1);

        rod.getBooks().add(noEJB);
        publisherRepository.save(p1);
        authorRepository.save(rod);
        bookRepository.save(noEJB);


    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
