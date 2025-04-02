package com.mehrana.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractLeave {

    private Long id;
    private LocalDate leaveDate;
    private LocalDate leaveStartDate;
    private LocalDate leaveEndDate;
    private String leaveType;
    private String leaveReason;
    private Personnel personnel;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "leave_date")
    public LocalDate getLeaveDate() {
        return leaveDate;
    }
    public void setLeaveDate(LocalDate leaveDate) {
        this.leaveDate = leaveDate;
    }

    @Column(name = "start_date")
    public LocalDate getLeaveStartDate() {
        return leaveStartDate;
    }
    public void setLeaveStartDate(LocalDate leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    @Column(name = "end_date")
    public LocalDate getLeaveEndDate() {
        return leaveEndDate;
    }
    public void setLeaveEndDate(LocalDate leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    @Column(name = "type")
    public String getLeaveType() {
        return leaveType;
    }
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    @Column(name = "reason")
    public String getLeaveReason() {
        return leaveReason;
    }
    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personnel_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_personnel_leave"))
    public Personnel getPersonnel() {
        return personnel;
    }
    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    @Override
    public String toString() {
        return "AbstractLeave{" +
                "id=" + id +
                ", leaveDate=" + leaveDate +
                ", leaveStartDate=" + leaveStartDate +
                ", leaveEndDate=" + leaveEndDate +
                ", leaveType='" + leaveType + '\'' +
                ", leaveReason='" + leaveReason + '\'' +
                ", personnel=" + personnel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractLeave that = (AbstractLeave) o;
        return Objects.equals(id, that.id) && Objects.equals(leaveDate, that.leaveDate) && Objects.equals(leaveStartDate, that.leaveStartDate) && Objects.equals(leaveEndDate, that.leaveEndDate) && Objects.equals(leaveType, that.leaveType) && Objects.equals(leaveReason, that.leaveReason) && Objects.equals(personnel, that.personnel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, leaveDate, leaveStartDate, leaveEndDate, leaveType, leaveReason, personnel);
    }
}
