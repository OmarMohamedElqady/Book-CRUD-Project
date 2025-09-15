package com.bookApi.Books.controller;

import com.bookApi.Books.entity.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final List<Book> books = new ArrayList<>();
    public BookController() {
        initializeBooks();
    }

    private void initializeBooks() {
        books.addAll(List.of(
                new Book("Title one", "Author one", "science"),
                new Book("Title two", "Author two", "science"),
                new Book("Title three", "Author three", "history"),
                new Book("Title four", "Author four", "math"),
                new Book("Title five", "Author five", "math"),
                new Book("Title six", "Author six", "math"),
                new Book("Title seven", "Author seven", "science")
                ));
    }

    @GetMapping()
    public List<Book> getBooks(){
        return books;
    }

//    @GetMapping("/{title}")
//    public Book getBookByTitle(@PathVariable String title) {
//        for (Book book: books) {
//            if (book.getTitle().equalsIgnoreCase(title)){
//                return book;
//            }
//        } return null;
//    }

    // PathVariable --> {}
    @GetMapping("/{title}/findbook")
    public Book getBookByTitle(@PathVariable String title) {
                return books.stream()
                        .filter(book -> book.getTitle().equalsIgnoreCase(title))
                        .findFirst()
                        .orElse(null);
            }

//    @GetMapping("/filtered")
//        public List<Book> getBooksFiltered(@RequestParam(required = false) String category){
//            if (category == null) {
//                return books;
//            }
//            List<Book> filteredBook = new ArrayList<>();
//            for (Book book: books){
//                if (book.getCategory().equalsIgnoreCase(category)){
//                    filteredBook.add(book);
//                }
//            }
//            return filteredBook;
//        }

    // Query Parameter --> @RequestParam
    @GetMapping("/filtered")
    public List<Book>getBooksFilter(@RequestParam(required = false) String category){
        if (category == null) {
            return books;
        }
        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    // @PostMapping --> @RequestBody
//    @PostMapping("/")
//    public void createBook(@RequestBody Book newBook){
//        for (Book book: books){
//            if (book.getTitle().equalsIgnoreCase(newBook.getTitle())){
//                return;
//            }
//        }
//        books.add(newBook);
//    }

    @PostMapping("")
    public void createBook(@RequestBody Book newBook){
        boolean isNewBook = books.stream()
                .noneMatch(book -> book.getTitle().equalsIgnoreCase(newBook.getTitle()));
        if (isNewBook){
            books.add(newBook);
        }
    }

    @PutMapping("/{title}")
    public void updateBook(@PathVariable String title,
                           @RequestBody Book updatedBook){
        for (int i = 0; i< books.size(); i++){
            if (books.get(i).getTitle().equalsIgnoreCase(title)){
                books.set(i, updatedBook);
                return;
            }
        }
    }

    @DeleteMapping("/{title}")
    public void deleteBook(@PathVariable String title){
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

}
