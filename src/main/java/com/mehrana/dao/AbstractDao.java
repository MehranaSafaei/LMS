package com.mehrana.dao;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

public abstract class AbstractDao<T> {

    @Inject
    protected EntityManager entityManager;

    private final Class<T> entityClass;

    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Transactional
    public void save(T entity) {
        entityManager.persist(entity);
    }

    @Transactional
    public void update(T entity) {
        entityManager.merge(entity);
    }

    public T findById(Object id) {
        return entityManager.find(entityClass, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
    }

    @Transactional
    public void delete(T entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
}
