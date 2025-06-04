package com.bookstore.controller;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // Show all books on homepage
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "index";  // Return templates/index.html
    }

    // Show form to add a new book
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "add_book";  // Return templates/add_book.html
    }

    // Save book to database
    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/";  // Go back to homepage
    }

    // Show form to edit existing book
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow();
        model.addAttribute("book", book);
        return "edit_book";
    }

    // Update book in database
    @PostMapping("/update")
    public String updateBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }

    // Delete book
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
        return "redirect:/";
    }
}
