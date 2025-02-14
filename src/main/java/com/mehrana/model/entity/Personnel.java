package com.mehrana.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "personnel")
@NamedQueries({@NamedQuery(name = "selectByPersonnelCode", query = "SELECT p FROM Personnel p WHERE p.personnelCode = :personnelCode"),
@NamedQuery(name = "selectByUsername", query = "SELECT p FROM Personnel p WHERE p.username = :username")})
public class Personnel extends AbstractPersonnel{

    public Personnel() {}
}
