package com.mehrana.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@MappedSuperclass
public abstract class AbstractPersonnel {

    private Long id;
    private String username;
    private String password;
    private Long personnelCode;
    private Set<Leave> leaves;
    private Set<Role> roles = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "username", unique = true)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "personnel_code", unique = true, nullable = false)
    public Long getPersonnelCode() {
        return personnelCode;
    }
    public void setPersonnelCode(Long personnelCode) {
        this.personnelCode = personnelCode;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "personnel")
    public Set<Leave> getLeaves() {
        return leaves;
    }
    public void setLeaves(Set<Leave> leaves) {
        this.leaves = leaves;
    }

    @Override
    public String toString() {
        return "AbstractPersonnel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", personnelCode=" + personnelCode +
                ", leaves=" + leaves +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPersonnel that = (AbstractPersonnel) o;
        return Objects.equals(id, that.id)
                && Objects.equals(username, that.username)
                && Objects.equals(password, that.password)
                && Objects.equals(personnelCode, that.personnelCode)
                && Objects.equals(leaves, that.leaves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, personnelCode, leaves);
    }
}
