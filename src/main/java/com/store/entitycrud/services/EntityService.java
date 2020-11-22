package com.store.entitycrud.services;

import java.util.Optional;

import com.store.entitycrud.entities.Entity;
import com.store.entitycrud.forms.EntityForm;
import com.store.entitycrud.repositories.EntityRepository;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javassist.NotFoundException;
import javassist.bytecode.DuplicateMemberException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EntityService {
    private final EntityRepository entityRepository;

    public Iterable<Entity> findAll() {
        return this.entityRepository.findAll();
    }

    public void delete(final Long id) throws NotFoundException {
        Assert.notNull(id, "id cannot be null");
        
        final Optional<Entity> model = this.entityRepository.findById(id);

        if (!model.isPresent()) {
            throw new NotFoundException("Entity with not found with ID:" + id);
        }

        this.entityRepository.delete(model.get());
    }

    public Entity create(final EntityForm entityForm) throws DuplicateMemberException {
        Assert.notNull(entityForm, "entity cannot be null");
        
        final String name = entityForm.getName();
        final Optional<Entity> model = this.entityRepository.findByName(name);
        
        if (model.isPresent()) {
            throw new DuplicateMemberException("Entity with name " + name + " already in use");
        }

        final Entity entity = new Entity();
        entity.setName(entityForm.getName());
        entity.setVersion(entityForm.getVersion());

        return this.entityRepository.save(entity);
    }


    public Entity update(final Long id, final EntityForm entityForm) throws NotFoundException {
        Assert.notNull(id, "id cannot be null");
        Assert.notNull(entityForm, "entity cannot be null");

        final Optional<Entity> model = this.entityRepository.findById(id);
        
        if (!model.isPresent()) {
            throw new NotFoundException("Entity with not found with ID:" + id);
        }

        model.ifPresent(m -> {
            m.setName(entityForm.getName());
            m.setVersion(entityForm.getVersion());
            this.entityRepository.save(m);
        });

        return model.get();
    }
}