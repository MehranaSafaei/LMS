package com.mehrana.mapper;


import com.mehrana.model.dto.LeaveDto;
import com.mehrana.model.dto.PersonnelDto;
import com.mehrana.model.dto.UpdateLeaveRequest;
import com.mehrana.model.dto.UpdatePersonnelRequest;
import com.mehrana.model.entity.Leave;
import com.mehrana.model.entity.Personnel;

public class DtoMapper {

    //Convert dto to entity
    public static Personnel toEntity(PersonnelDto dto) {
        Personnel personnel = new Personnel();
        personnel.setUsername(dto.getUsername());
        personnel.setPassword(dto.getPassword());
        personnel.setPersonnelCode(dto.getPersonnelCode());
        return personnel;
    }

    //Convert entity to dto
    public static PersonnelDto toDTO(Personnel entity) {
        PersonnelDto personnelDto = new PersonnelDto();
        personnelDto.setId(entity.getId());
        personnelDto.setUsername(entity.getUsername());
//        personnelDto.setPassword(entity.getPassword());
        personnelDto.setPersonnelCode(entity.getPersonnelCode());
        return personnelDto;
    }

    //Convert entity to dto
    public static LeaveDto toDTO(Leave leave) {
        LeaveDto dto = new LeaveDto();
        dto.setId(leave.getId());
        dto.setLeaveStartDate(leave.getLeaveStartDate());
        dto.setLeaveEndDate(leave.getLeaveEndDate());
//        dto.setLeaveReason(leave.getLeaveReason());
//        dto.setPersonnelDto(leave.getPersonnel().getId());
        dto.setPersonnelDto(toDTO(leave.getPersonnel()));
        return dto;
    }

    //Convert dto to entity
    public static Leave toEntity(LeaveDto dto, Personnel personnel) {
        Leave leave = new Leave();
//        leave.setId(dto.getId());  //I made mistake because I don't set ID
//        leave.setLeaveDate(dto.getLeaveDate());
        leave.setLeaveStartDate(dto.getLeaveStartDate());
        leave.setLeaveEndDate(dto.getLeaveEndDate());
//        leave.setLeaveReason(dto.getLeaveReason());
        leave.setPersonnel(personnel);

        return leave;
    }

    public static void updateEntityFromDto(UpdateLeaveRequest dto, Leave entity) {
        entity.setLeaveStartDate(dto.getNewStartDateLeave());
        entity.setLeaveEndDate(dto.getNewEndDateLeave());
        entity.setLeaveReason(dto.getNewReason());
    }

    public static Personnel updateEntityFromDto(UpdatePersonnelRequest dto, Personnel entity) {
        if (dto.getNewPassword() != null) entity.setUsername(dto.getNewUsername());
        if (dto.getNewPassword() != null) entity.setPassword(dto.getNewPassword());
//        if (dto.getPersonnelCode() != null) entity.setPersonnelCode(dto.getPersonnelCode());
        return entity;
    }


}

