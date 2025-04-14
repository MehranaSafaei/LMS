package com.mehrana.dao;

import com.mehrana.model.entity.Permission;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PermissionDao extends AbstractDao<Permission> {

    public PermissionDao(Class<Permission> entityClass) {
        super(entityClass);
    }

    public void deleteById(Long id) {
        Permission permission = findById(id);
        if (permission != null) {
            delete(permission);
        }
    }
}
