package edu.spring.mvc.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.mvc.project.domain.entity.Book;
import edu.spring.mvc.project.service.IBookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private IBookService<Book> bookService;

    @PostMapping(value = "/add")
    public ResponseEntity<Book> add(@RequestBody Book Book) {
        Book result = null;
        try {
            result = bookService.create(Book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Book>> libros() throws Exception {
        List<Book> result = null;
        try {
            result = bookService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(result);
    }

}
