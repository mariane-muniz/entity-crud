package com.store.entitycrud.repositories;

import java.util.Optional;

import com.store.entitycrud.entities.Entity;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface EntityRepository extends PagingAndSortingRepository<Entity, Long> {
    public Optional<Entity> findByName(final String name);
}