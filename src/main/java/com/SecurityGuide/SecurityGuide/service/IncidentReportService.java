package com.SecurityGuide.SecurityGuide.service;

import com.SecurityGuide.SecurityGuide.dto.IncidentReportDTO;
import com.SecurityGuide.SecurityGuide.entity.IncidentReport;
import com.SecurityGuide.SecurityGuide.mapper.IncidentReportMapper;
import com.SecurityGuide.SecurityGuide.repository.IncidentReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IncidentReportService {

    @Autowired
    private IncidentReportRepository incidentReportRepository;

    // Create a new IncidentReport
    public IncidentReportDTO createIncidentReport(IncidentReportDTO incidentReportDTO) {
        IncidentReport incidentReport = IncidentReportMapper.toEntity(incidentReportDTO);
        IncidentReport savedIncidentReport = incidentReportRepository.save(incidentReport);
        return IncidentReportMapper.toDto(savedIncidentReport);
    }

    // Get an IncidentReport by ID
    public IncidentReportDTO getIncidentReportById(Long id) {
        Optional<IncidentReport> incidentReportOpt = incidentReportRepository.findById(id);
        if (incidentReportOpt.isPresent()) {
            return IncidentReportMapper.toDto(incidentReportOpt.get());
        } else {
            throw new RuntimeException("Incident not found with ID: " + id);
        }
    }

    // Get all IncidentReports
    public List<IncidentReportDTO> getAllIncidentReports() {
        List<IncidentReport> incidentReports = incidentReportRepository.findAll();
        return incidentReports.stream()
                .map(IncidentReportMapper::toDto)
                .collect(Collectors.toList());
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
