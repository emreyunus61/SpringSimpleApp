package com.example.petclinicapp.repositories;

import com.example.petclinicapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long > {

}
