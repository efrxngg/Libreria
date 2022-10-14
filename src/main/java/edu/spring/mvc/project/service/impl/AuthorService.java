package edu.spring.mvc.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.mvc.project.domain.entity.Author;
import edu.spring.mvc.project.repo.IAuthorRepository;
import edu.spring.mvc.project.service.IAuthorService;

@Service
public class AuthorService implements IAuthorService<Author> {

    @Autowired
    private IAuthorRepository repository;

    @Override
    /**
     * Podemos anotar una clase o metodo con @Transactional
     * Usamos transactional para serparar el codigo de la gestion de transacciones
     * del codigo
     * que incorpora la logica de empresarial
     */
    @Transactional(propagation = Propagation.REQUIRED)//Limite de transaccion de nuestra logica empresarial
    public Author create(Author entity) throws Exception {
        Author result = null;
        try {
            result = repository.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, readOnly = true)//Representa que la transaccion es de solo lectura
    public List<Author> findAll() throws Exception {
        List<Author> result = null;
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
    public Author findById(int id) throws Exception {
        Author result = null;
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
    public Author update(Author entity, int id) throws Exception {
        Author result = null;
        try {
            entity.setId_author(id);
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
                Author obj = optional.get();
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
