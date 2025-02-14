package com.mehrana.model.dto;

import java.time.LocalDate;

public class LeaveDto {

    private Long id;
//    private LocalDate leaveDate;
    private LocalDate leaveStartDate;
    private LocalDate leaveEndDate;
    private String leaveType;
//    private String leaveReason;
    private PersonnelDto personnelDto;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

//    public LocalDate getLeaveDate() {
//        return leaveDate;
//    }
//    public void setLeaveDate(LocalDate leaveDate) {
//        this.leaveDate = leaveDate;
//    }

    public LocalDate getLeaveStartDate() {
        return leaveStartDate;
    }
    public void setLeaveStartDate(LocalDate leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public LocalDate getLeaveEndDate() {
        return leaveEndDate;
    }
    public void setLeaveEndDate(LocalDate leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public String getLeaveType() {
        return leaveType;
    }
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

//    public String getLeaveReason() {
//        return leaveReason;
//    }
//    public void setLeaveReason(String leaveReason) {
//        this.leaveReason = leaveReason;
//    }

    public PersonnelDto getPersonnelDto() {
        return personnelDto;
    }
    public void setPersonnelDto(PersonnelDto personnelDto) {
        this.personnelDto = personnelDto;
    }
}
