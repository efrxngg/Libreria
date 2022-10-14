package edu.spring.mvc.project.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "style")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Style {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_style;

    private String name;

    private String description;

    private boolean state;

}
