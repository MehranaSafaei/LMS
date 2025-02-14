package com.mehrana.dao;

import com.mehrana.model.entity.MyEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class MyEntityDao {
    @Inject
    EntityManager em;
    public List<MyEntity> findAll() {
       return new ArrayList<MyEntity>();
    }
    public void save(MyEntity myEntity) {}
}
