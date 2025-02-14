package com.mehrana.service;

import com.mehrana.dao.MyEntityDao;
import com.mehrana.model.entity.MyEntity;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class MyEntityService {
    @Inject
    MyEntityDao dao;

    public List<MyEntity> findAll() {
        return dao.findAll();
    }
}
