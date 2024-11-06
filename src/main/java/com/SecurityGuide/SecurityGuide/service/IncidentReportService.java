package com.SecurityGuide.SecurityGuide.service;

import com.SecurityGuide.SecurityGuide.dto.IncidentReportDTO;
import com.SecurityGuide.SecurityGuide.entity.IncidentReport;
import com.SecurityGuide.SecurityGuide.entity.SystemUsers;
import com.SecurityGuide.SecurityGuide.mapper.IncidentReportMapper;
import com.SecurityGuide.SecurityGuide.repository.IncidentReportRepository;
import com.SecurityGuide.SecurityGuide.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IncidentReportService {
    private static final Logger logger = LoggerFactory.getLogger(IncidentReportService.class);

    @Autowired
    private IncidentReportRepository incidentReportRepository;
    @Autowired
    private UsersRepo usersRepo;

    // Create a new IncidentReport
    public IncidentReportDTO createIncidentReport(IncidentReportDTO incidentReportDTO) {
        IncidentReport incidentReport = IncidentReportMapper.toEntity(incidentReportDTO);
        IncidentReport savedIncidentReport = incidentReportRepository.save(incidentReport);
        return IncidentReportMapper.toDto(savedIncidentReport);
    }

    // Get an IncidentReport by ID
    public IncidentReportDTO getIncidentReportById(Long id) {
        Optional<IncidentReport> incidentReportOpt = incidentReportRepository.findById(id);
        logger.info("Fetching incident report with ID: {}", id);
        logger.debug("Incident Report Optional: {}", incidentReportOpt);
        if (incidentReportOpt.isPresent()) {
            return IncidentReportMapper.toDto(incidentReportOpt.get());
        } else {
            throw new RuntimeException("Incident not found with ID: " + id);
        }
    }

    // Get all IncidentReports
    public Page<IncidentReportDTO> getAllIncidentReports(String searchTerm, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());

        if (searchTerm != null && !searchTerm.isEmpty()) {
            // Use a custom query method to filter results based on the searchTerm
            return incidentReportRepository.findBySearchTerm(searchTerm, pageable)
                    .map(IncidentReportMapper::toDto);
        } else {
            // If no search term is provided, fetch all records
            return incidentReportRepository.findAll(pageable)
                    .map(IncidentReportMapper::toDto);
        }
    }



    // Update an existing IncidentReport
    public IncidentReportDTO updateIncidentReport(Long id, IncidentReportDTO incidentReportDTO) {
        Optional<IncidentReport> existingIncidentReportOpt = incidentReportRepository.findById(id);
        if (existingIncidentReportOpt.isPresent()) {
            IncidentReport existingIncidentReport = existingIncidentReportOpt.get();

            // Update fields
            existingIncidentReport.setCallerName(incidentReportDTO.getCallerName());
            existingIncidentReport.setCallTime(incidentReportDTO.getCallTime());
            existingIncidentReport.setCallerContactInfo(incidentReportDTO.getCallerContactInfo());
            existingIncidentReport.setIncidentNature(incidentReportDTO.getIncidentNature());
            existingIncidentReport.setEquipmentOrPersonsInvolved(incidentReportDTO.getEquipmentOrPersonsInvolved());
            existingIncidentReport.setLocationOfInvolved(incidentReportDTO.getLocationOfInvolved());
            existingIncidentReport.setIncidentDetection(incidentReportDTO.getIncidentDetection());

            // Save updated entity
            IncidentReport updatedIncidentReport = incidentReportRepository.save(existingIncidentReport);
            return IncidentReportMapper.toDto(updatedIncidentReport);
        } else {
            throw new RuntimeException("Incident not found with ID: " + id);
        }
    }

    // Delete an IncidentReport by ID
    public void deleteIncidentReport(Long id) {
        if (incidentReportRepository.existsById(id)) {
            incidentReportRepository.deleteById(id);
        } else {
            throw new RuntimeException("Incident not found with ID: " + id);
        }
    }
}
