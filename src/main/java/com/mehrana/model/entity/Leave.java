package com.mehrana.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "leave")
public class Leave extends AbstractLeave{
    public Leave() {}
}
