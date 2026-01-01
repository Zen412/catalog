package org.Bookstore.catalog.service;

import org.Bookstore.catalog.domain.Book;
import org.Bookstore.catalog.exceptionhandling.BookAlreadyExistsException;
import org.Bookstore.catalog.exceptionhandling.BookNotFoundException;
import org.Bookstore.catalog.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> viewBookList() {
        // Placeholder for fetching all books
        return bookRepository.findAll();
    }

    public Book viewBookDetails(String isbn){
        return bookRepository.findByIsbn(isbn)
        .orElseThrow(()-> new BookNotFoundException(isbn));
    }

    public Book addBookToCatalog(Book book){
        if(bookRepository.existsById(book.isbn())){
            throw new BookAlreadyExistsException(book.isbn());
        }
        return bookRepository.save(book);

    }

    public void removeBookFromCatalog(String isbn){
        if(!bookRepository.existsById(isbn)){
            throw new BookNotFoundException(isbn);
        }
        bookRepository.deleteById(isbn);
    }

    public Book editBookDetails(String isbn, Book book){
        return bookRepository.findByIsbn(isbn)
            .map(existingbook -> {
                var bookToUpdate = new Book(
                    existingbook.isbn(),
                    book.title(),
                    book.author(),
                    book.price());
                return bookRepository.save(bookToUpdate);
            })
            .orElseGet(() -> addBookToCatalog(book));
    }
    
}
