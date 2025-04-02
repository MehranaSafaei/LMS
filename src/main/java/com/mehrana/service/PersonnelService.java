package com.mehrana.service;

import com.mehrana.dao.PersonnelDao;
import com.mehrana.mapper.DtoMapper;
import com.mehrana.model.dto.PersonnelDto;
import com.mehrana.model.dto.UpdatePersonnelRequest;
import com.mehrana.model.entity.Personnel;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.Optional;

@RequestScoped
public class PersonnelService {

    @Inject
    private PersonnelDao personnelDao;

    public Personnel create(PersonnelDto personnelDto) {
        Personnel personnel = DtoMapper.toEntity(personnelDto);
        personnelDao.save(personnel);
        return personnel;
    }

    public List<PersonnelDto> findAll() {
        List<Personnel> personnelList = personnelDao.findAll();
        return personnelList.stream().map(DtoMapper::toDTO).toList();
    }

    public void updateById(Long id, UpdatePersonnelRequest request) {
        Optional<Personnel> existingPersonnel = personnelDao.findByIdOptional(id);

        if (existingPersonnel.isEmpty()) {
            throw new EntityNotFoundException("Personnel with ID " + id + " not found.");
        }

        Personnel updatedPersonnel = DtoMapper.updateEntityFromDto(request, existingPersonnel.get());
        personnelDao.update(updatedPersonnel);
    }

    public void updateByPersonnelCode(Long personnelCode, UpdatePersonnelRequest request) {
        Optional<Personnel> existingPersonnel = personnelDao.findByPersonnelCode(personnelCode);

        if (existingPersonnel.isEmpty()) {
            throw new EntityNotFoundException("Personnel with code " + personnelCode + " not found.");
        }

        Personnel updatedPersonnel = DtoMapper.updateEntityFromDto(request, existingPersonnel.get());
        personnelDao.update(updatedPersonnel);
    }


    public void delete(Long id) {
        Personnel personnel = personnelDao.findById(id);
        if (personnel == null) {
            throw new EntityNotFoundException("Personnel with ID " + id + " not found");
        }
        personnelDao.delete(personnel);
    }

    public PersonnelDto findByUsername(String username) {
        Optional<Personnel> personnel = Optional.ofNullable(personnelDao.findByUsername(username));
        if (personnel.isEmpty()) {
            throw new NotFoundException("Personnel with username " + username + " not found.");
        }
        return DtoMapper.toDTO(personnel.get());
    }

    public PersonnelDto findById(Long id) {
        Optional<Personnel> personnel = personnelDao.findByIdOptional(id);
        if (personnel.isEmpty()) {
            throw new NotFoundException("Personnel with ID " + id + " not found.");
        }
        return DtoMapper.toDTO(personnel.get());
    }

    public Personnel findByPersonnelCode(Long personnelCode) {
        return personnelDao.findByPersonnelCode(personnelCode)
                .orElseThrow(() -> new NotFoundException("Personnel with national code " + personnelCode + " not found."));
    }
}
