package edu.spring.mvc.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.mvc.project.domain.entity.Theme;
import edu.spring.mvc.project.service.IThemeService;

@RestController
@RequestMapping(value = "/theme")
public class ThemeController {

    @Autowired
    private IThemeService<Theme> themeService;

    @PostMapping(value = "/add")
    public ResponseEntity<Theme> add(@RequestBody Theme Theme) {
        Theme result = null;
        try {
            result = themeService.create(Theme);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Theme>> libros() {
        List<Theme> result = null;
        try {
            result = themeService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(result);
    }

}
