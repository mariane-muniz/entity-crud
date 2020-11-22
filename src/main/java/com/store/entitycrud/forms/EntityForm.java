package com.store.entitycrud.forms;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityForm {
    @NotEmpty
    private String name;
    @NotEmpty
    private int version;
}