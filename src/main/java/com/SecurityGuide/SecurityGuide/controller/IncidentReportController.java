package com.SecurityGuide.SecurityGuide.controller;

import com.SecurityGuide.SecurityGuide.dto.IncidentReportDTO;
import com.SecurityGuide.SecurityGuide.service.IncidentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class IncidentReportController {

    @Autowired
    private IncidentReportService incidentReportService;

    // Create a new IncidentReport
    @PostMapping("/public/add-incident")
    public ResponseEntity<IncidentReportDTO> createIncidentReport(@RequestBody IncidentReportDTO incidentReportDTO) {
        IncidentReportDTO createdIncidentReport = incidentReportService.createIncidentReport(incidentReportDTO);
        return ResponseEntity.ok(createdIncidentReport);
    }

    // Get an IncidentReport by ID
    @GetMapping("get-incident/{id}")
    public ResponseEntity<IncidentReportDTO> getIncidentReportById(@PathVariable Long id) {
        IncidentReportDTO incidentReportDTO = incidentReportService.getIncidentReportById(id);
        return ResponseEntity.ok(incidentReportDTO);
    }

    // Get all IncidentReports
    @GetMapping("/admin/get-incidents")
    public ResponseEntity<List<IncidentReportDTO>> getAllIncidentReports() {
        List<IncidentReportDTO> incidentReports = incidentReportService.getAllIncidentReports();
        return ResponseEntity.ok(incidentReports);
    }

    // Update an IncidentReport
    @PutMapping("update-incident/{id}")
    public ResponseEntity<IncidentReportDTO> updateIncidentReport(@PathVariable Long id, @RequestBody IncidentReportDTO incidentReportDTO) {
        IncidentReportDTO updatedIncidentReport = incidentReportService.updateIncidentReport(id, incidentReportDTO);
        return ResponseEntity.ok(updatedIncidentReport);
    }

    // Delete an IncidentReport
    @DeleteMapping("delete-incident/{id}")
    public ResponseEntity<Void> deleteIncidentReport(@PathVariable Long id) {
        incidentReportService.deleteIncidentReport(id);
        return ResponseEntity.noContent().build();
    }
}
