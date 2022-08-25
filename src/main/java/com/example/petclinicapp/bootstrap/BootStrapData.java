package com.example.petclinicapp.bootstrap;

import com.example.petclinicapp.domain.Author;
import com.example.petclinicapp.domain.Book;
import com.example.petclinicapp.domain.Puhlisher;
import com.example.petclinicapp.repositories.AuthorRepository;
import com.example.petclinicapp.repositories.BookRepository;
import com.example.petclinicapp.repositories.PuhlisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Flow;

@Component
public class BootStrapData implements CommandLineRunner {

    private  final AuthorRepository authorRepository;
    private  final BookRepository   bookRepository;
    private  final PuhlisherRepository puhlisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PuhlisherRepository puhlisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.puhlisherRepository = puhlisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(" Bootstrap in Yunus Emre ");

        Puhlisher puhlisher = new Puhlisher();
        puhlisher.setName("SFG Puhlisher");
        puhlisher.setCity("Trabzon");
        puhlisher.setState("FL");

        puhlisherRepository.save(puhlisher);

        System.out.println("Puhlisher count: "+ puhlisherRepository.count());


        Author eric = new Author("eric","kaya");
        Book   b = new Book("Adam Oğlu adam", "6161" );
        eric.getBooks().add(b);
        b.getAuthors().add(eric);

        b.setPuhlisher(puhlisher);
        puhlisher.getBooks().add(b);

        authorRepository.save(eric);
        bookRepository.save(b);
        puhlisherRepository.save(puhlisher);

      System.out.println("Number of books: " + bookRepository.count());
      System.out.println("Puhlisher  number of books: "+ puhlisher.getBooks().size());

        System.out.println("Project name change");
    }
}
