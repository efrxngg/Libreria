package edu.spring.mvc.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.mvc.project.domain.entity.Style;
import edu.spring.mvc.project.service.IStyleService;

@RestController
@RequestMapping(value = "/style")
public class StyleController {

    @Autowired
    private IStyleService<Style> styleService;

    @PostMapping(value = "/add")
    public ResponseEntity<Style> add(@RequestBody Style Style) {
        Style result = null;
        try {
            result = styleService.create(Style);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Style>> libros() {
        List<Style> result = null;
        try {
            result = styleService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(result);
    }

}
