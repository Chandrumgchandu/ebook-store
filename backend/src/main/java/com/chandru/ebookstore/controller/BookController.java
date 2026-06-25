package com.chandru.ebookstore.controller;

import com.chandru.ebookstore.entity.Book;
import com.chandru.ebookstore.entity.Category;
import com.chandru.ebookstore.repository.CategoryRepository;
import com.chandru.ebookstore.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(
        @PathVariable Long id,
        @RequestBody Book updatedBook) {

        Book existingBook =
            bookRepository.findById(id).orElse(null);

        if (existingBook == null) {
            return null;
        }

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setPrice(updatedBook.getPrice());
        existingBook.setStock(updatedBook.getStock());
        if (updatedBook.getCategory() != null) {

        Category category =
            categoryRepository.findById(
                    updatedBook.getCategory().getId()
            ).orElse(null);
        existingBook.setCategory(category);
    }
        return bookRepository.save(existingBook);
    }
}

