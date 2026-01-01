package org.Bookstore.catalog.exceptionhandling;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String isbn) {
        super("Book with ISBN " + isbn + " not found.");
    }
    
}
