package com.store.entitycrud.controllers;

import com.store.entitycrud.entities.Entity;
import com.store.entitycrud.forms.EntityForm;
import com.store.entitycrud.services.EntityService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;
import javassist.bytecode.DuplicateMemberException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class EntityController {
    private final EntityService entityService;

    @GetMapping
    public ResponseEntity<Iterable<Entity>> findAll() {
        return ResponseEntity.ok(this.entityService.findAll());
    }

    @PostMapping
    public ResponseEntity<Entity> create(@RequestBody EntityForm entityForm) throws DuplicateMemberException {
        return ResponseEntity.ok(this.entityService.create(entityForm));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entity> update(
        @RequestBody final EntityForm entityForm,
        @PathVariable final Long id
    ) throws NotFoundException {
        return ResponseEntity.ok(
            this.entityService.update(id, entityForm)
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Long id) throws NotFoundException {
        this.entityService.delete(id);
    }
}