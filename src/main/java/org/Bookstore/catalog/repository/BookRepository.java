package org.Bookstore.catalog.repository;

import org.Bookstore.catalog.domain.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface  BookRepository {
    Iterable<Book> findAll();
    java.util.Optional<Book> findByIsbn(String isbn);
    boolean existsById(String isbn);
    Book save(Book book);
    void deleteById(String isbn);
    
}
