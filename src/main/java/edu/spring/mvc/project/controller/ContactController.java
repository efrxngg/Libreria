package edu.spring.mvc.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.mvc.project.domain.entity.Contact;
import edu.spring.mvc.project.service.IContactService;

@RestController
@RequestMapping(value = "/api/v1/contact")
public class ContactController {

    @Autowired
    private IContactService<Contact> contactService;

    @PostMapping(value = "/add")
    public ResponseEntity<Contact> add(@RequestBody Contact Contact) {
        Contact result = null;
        try {
            result = contactService.create(Contact);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Contact>> libros() {
        List<Contact> result = null;
        try {
            result = contactService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(result);
    }

}
