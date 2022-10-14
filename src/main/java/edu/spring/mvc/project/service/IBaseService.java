package edu.spring.mvc.project.service;

import java.util.List;

public interface IBaseService<E> {
    
    E create(E entity) throws Exception;

    List<E> findAll() throws Exception;

    E findById(int id) throws Exception;

    E update(E entity, int id) throws Exception;

    boolean delete(int id) throws Exception;
}
