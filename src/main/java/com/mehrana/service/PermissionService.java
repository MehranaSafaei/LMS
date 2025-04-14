package com.mehrana.service;

import com.mehrana.dao.PermissionDao;
import com.mehrana.model.entity.Permission;
import jakarta.enterprise.context.RequestScoped;

import java.util.List;

@RequestScoped
public class PermissionService {

    public PermissionDao permissionDao;


    public void createPermission(Permission permission) {
        try {
            permissionDao.save(permission);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Permission> getAllPermissions() {
       try {
           return permissionDao.findAll();
       }catch (Exception e){
           e.printStackTrace();
       }
       return null;
    }

    public Permission getPermissionById(Long id) {
        try {
            return permissionDao.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void deletePermissionById(Long id) {
       try{
           permissionDao.deleteById(id);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public void updatePermission(Permission permission) {
        try {
            permissionDao.update(permission);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
