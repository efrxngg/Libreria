package edu.spring.mvc.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.mvc.project.domain.entity.Author;
import edu.spring.mvc.project.service.IAuthorService;

@RestController
@RequestMapping(value = "/api/v1/author")
public class AuthorController {

    @Autowired
    private IAuthorService<Author> authorService;

    @PostMapping(value = "/add")
    public ResponseEntity<Author> add(@RequestBody Author author) {
        Author result = null;
        try {
            result = authorService.create(author);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Author>> libros() {
        List<Author> result = null;
        try {
            result = authorService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(result);
    }

}
