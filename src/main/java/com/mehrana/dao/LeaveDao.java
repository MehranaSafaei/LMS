package com.mehrana.dao;

import com.mehrana.model.entity.Leave;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.Optional;

@ApplicationScoped
public class LeaveDao extends AbstractDao<Leave> {
    public LeaveDao() {
        super(Leave.class);
    }

    public Optional<Leave> findByIdOptional(Long leaveId) {
        return null;
    }

    public boolean existsByPersonnelIdAndDateRange(Long personnelId, LocalDate startDate, LocalDate endDate) {
        return false;
    }
}
