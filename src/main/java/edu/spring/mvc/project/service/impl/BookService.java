package edu.spring.mvc.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.mvc.project.domain.entity.Book;
import edu.spring.mvc.project.repo.IBookRepository;
import edu.spring.mvc.project.service.IBookService;

@Service
public class BookService implements IBookService<Book> {

    @Autowired
    private IBookRepository repository;

    @Override
    /**
     * Podemos anotar una clase o metodo con @Transactional
     * Usamos transactional para serparar el codigo de la gestion de transacciones
     * del codigo
     * que incorpora la logica de empresarial
     */
    @Transactional(propagation = Propagation.REQUIRED)//Limite de transaccion de nuestra logica empresarial
    public Book create(Book entity) throws Exception {
        Book result = null;
        try {
            result = repository.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, readOnly = true)//Representa que la transaccion es de solo lectura
    public List<Book> findAll() throws Exception {
        List<Book> result = null;
        try {
            result = repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    // No revertir para Ille...class
    @Transactional(noRollbackFor = { IllegalArgumentException.class }, timeout = 5)
    public Book findById(int id) throws Exception {
        Book result = null;
        try {
            var obj = repository.findById(id);
            if (obj.isEmpty()) {
                result = obj.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = { IllegalArgumentException.class })
    public Book update(Book entity, int id) throws Exception {
        Book result = null;
        try {
            entity.setId_book(id);
            result = repository.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional(label = { "Descripcion de la transaccion del metodo" })
    public boolean delete(int id) throws Exception {
        boolean result = false;
        try {
            var optional = repository.findById(id);
            if (optional.isEmpty()) {
                Book obj = optional.get();
                obj.setState(false);
                repository.save(obj);
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
