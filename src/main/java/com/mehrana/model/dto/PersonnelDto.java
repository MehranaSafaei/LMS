package com.mehrana.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PersonnelDto {

    private Long id;
    private String username;
//    @JsonIgnore
    private String password;
    private Long personnelCode;
    private Long leaveId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPersonnelCode() {
        return personnelCode;
    }
    public void setPersonnelCode(Long personnelCode) {
        this.personnelCode = personnelCode;
    }

    public Long getLeaveId() {
        return leaveId;
    }
    public void setLeaveId(Long leaveId) {
        this.leaveId = leaveId;
    }
}
