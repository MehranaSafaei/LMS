package com.mehrana.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "permission")
public class Permission extends AbstractPermission {

    public Permission() {
        super();
    }
}
