package edu.spring.mvc.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.spring.mvc.project.domain.entity.Author;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Integer> {

}
