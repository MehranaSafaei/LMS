package com.mehrana.model.dto;

import java.time.LocalDate;

public class UpdateLeaveRequest {

    private LocalDate newStartDateLeave;
    private LocalDate newEndDateLeave;
    private String newReason;

    public LocalDate getNewStartDateLeave() {
        return newStartDateLeave;
    }
    public void setNewStartDateLeave(LocalDate newStartDateLeave) {
        this.newStartDateLeave = newStartDateLeave;
    }

    public LocalDate getNewEndDateLeave() {
        return newEndDateLeave;
    }
    public void setNewEndDateLeave(LocalDate newEndDateLeave) {
        this.newEndDateLeave = newEndDateLeave;
    }

    public String getNewReason() {
        return newReason;
    }
    public void setNewReason(String newReason) {
        this.newReason = newReason;
    }
}
