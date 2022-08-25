package com.example.petclinicapp.repositories;

import com.example.petclinicapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
