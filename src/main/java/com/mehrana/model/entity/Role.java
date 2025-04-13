package com.mehrana.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends AbstractRole {

    public Role() {
        super();
    }

}
