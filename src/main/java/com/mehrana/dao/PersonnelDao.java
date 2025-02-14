package com.mehrana.dao;

import com.mehrana.model.entity.Personnel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;

import java.util.Optional;

@ApplicationScoped
public class PersonnelDao extends AbstractDao<Personnel> {

    public PersonnelDao() {
        super(Personnel.class);
    }

    public Optional<Personnel> findByPersonnelCode(long personnelCode) {
        try {
            Personnel personnel = entityManager.createNamedQuery(
                            "selectByPersonnelCode", Personnel.class)
                    .setParameter("personnelCode", personnelCode)
                    .getSingleResult();
            return Optional.ofNullable(personnel);
        } catch (Exception e) {
            return Optional.empty();
        }
    }



    public Optional<Personnel> findByUsername(String username) {
        try {
            Personnel personnel = entityManager.createNamedQuery(
                            "selectByUsername", Personnel.class)
                    .setParameter("username", username)
                    .getSingleResult();
            return Optional.of(personnel);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public Optional<Personnel> findByIdOptional(Long id) {
        Personnel personnel = entityManager.find(Personnel.class, id);
        return Optional.ofNullable(personnel);
    }
}
