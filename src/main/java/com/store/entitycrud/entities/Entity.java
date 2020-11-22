package com.store.entitycrud.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@javax.persistence.Entity
@Getter
@Setter
@Table(name = "entities")
public class Entity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    
    @Column(nullable = false, unique = true)
    private int version;
}