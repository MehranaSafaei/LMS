package com.mehrana.service;

import com.mehrana.dao.LeaveDao;
import com.mehrana.mapper.DtoMapper;
import com.mehrana.model.dto.LeaveDto;
import com.mehrana.model.dto.UpdateLeaveRequest;
import com.mehrana.model.entity.Leave;
import com.mehrana.model.entity.Personnel;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class LeaveService {

    @Inject
    private LeaveDao leaveDao;

    @Inject
    private PersonnelService personnelService;

    public void create(Long personnelCode, LeaveDto leaveDto) {
        Personnel personnel = personnelService.findByPersonnelCode(personnelCode);

        if (isLeaveOverlap(personnel.getId(), leaveDto.getLeaveStartDate(), leaveDto.getLeaveEndDate())) {
            throw new IllegalArgumentException("Leave dates overlap with existing leave");
        }

        Leave leave = DtoMapper.toEntity(leaveDto, personnel);
        leaveDao.save(leave);
    }

    public List<LeaveDto> findAll() {
        List<Leave> leaveList = leaveDao.findAll();
        return leaveList.stream().map(DtoMapper::toDTO).toList();
    }

    public Leave update(Long leaveId, UpdateLeaveRequest leaveRequest) {
        Leave existingLeave = leaveDao.findByIdOptional(leaveId)
                .orElseThrow(() -> new NotFoundException("Leave with ID " + leaveId + " not found."));

        DtoMapper.updateEntityFromDto(leaveRequest, existingLeave);

        leaveDao.update(existingLeave);
        return existingLeave;
    }


    public void delete(Long id) {
        Leave leave = leaveDao.findById(id);
        if (leave == null) {
            throw new EntityNotFoundException("Leave with ID " + id + " not found");
        }
        leaveDao.delete(leave);
    }

    public LeaveDto findById(Long id) {
        Optional<Leave> leave = leaveDao.findByIdOptional(id);
        if (leave.isEmpty()) {
            throw new NotFoundException("Leave with ID " + id + " not found.");
        }
        return DtoMapper.toDTO(leave.get());
    }

    private boolean isLeaveOverlap(Long personnelId, LocalDate startDate, LocalDate endDate) {
        return leaveDao.existsByPersonnelIdAndDateRange(personnelId, startDate, endDate);
    }

    //    public Leave update(Long leaveId, UpdateLeaveRequest leaveRequest) {
//        Optional<Leave> existingLeave = leaveDao.findByIdOptional(leaveId);
//
//        if (existingLeave.isEmpty()) {
//            throw new NotFoundException("Leave with ID " + leaveId + " not found.");
//        }
//
////        Leave updatedLeave = DtoMapper.updateEntityFromDto(leaveRequest, existingLeave.get().getPersonnel());
//        DtoMapper.updateEntityFromDto(leaveRequest, existingLeave.get().getPersonnel());
//        updatedLeave.setId(existingLeave.get().getId());
//        leaveDao.update(updatedLeave);
//        return existingLeave;
//    }
}
