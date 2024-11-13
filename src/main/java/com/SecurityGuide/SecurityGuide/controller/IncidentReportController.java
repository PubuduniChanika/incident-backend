package com.SecurityGuide.SecurityGuide.controller;

import com.SecurityGuide.SecurityGuide.dto.IncidentReportDTO;
import com.SecurityGuide.SecurityGuide.dto.ReqRes;
import com.SecurityGuide.SecurityGuide.service.IncidentReportService;
import com.SecurityGuide.SecurityGuide.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class IncidentReportController {

    @Autowired
    private IncidentReportService incidentReportService;
    @Autowired
    private UserManagementService userManagementService;

    // Create a new IncidentReport
    @PostMapping("/public/add-incident")
    public ResponseEntity<IncidentReportDTO> createIncidentReport(@RequestBody IncidentReportDTO incidentReportDTO) {
        IncidentReportDTO createdIncidentReport = incidentReportService.createIncidentReport(incidentReportDTO);
        return ResponseEntity.ok(createdIncidentReport);
    }

    // Get an IncidentReport by ID
    @GetMapping("/admin/get-incident/{id}")
    public ResponseEntity<IncidentReportDTO> getIncidentReportById(@PathVariable Long id) {
        IncidentReportDTO incidentReportDTO = incidentReportService.getIncidentReportById(id);
        return ResponseEntity.ok(incidentReportDTO);
    }

    // Get all IncidentReports

    @GetMapping("/admin/get-incidents")
    public ResponseEntity<Page<IncidentReportDTO>> getAllIncidentReports(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String searchTerm) {

        Page<IncidentReportDTO> incidents = incidentReportService.getAllIncidentReports(searchTerm, page, size);

        if (incidents.hasContent()) {
            return ResponseEntity.ok(incidents);
        } else {
            return ResponseEntity.noContent().build(); // returns 204 if no incidents found
        }
    }



    // Update an IncidentReport
    @PutMapping("admin/update-incident/{id}")
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

    @GetMapping("/user/my-incidents")
    public ResponseEntity<Page<IncidentReportDTO>> getMyIncidents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String searchTerm) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Page<IncidentReportDTO> incidents = incidentReportService.getAllAssignedIncidentReports(searchTerm, page, size, email);

        if (incidents.hasContent()) {
            return ResponseEntity.ok(incidents); // 200 OK with content
        } else {
            return ResponseEntity.noContent().build(); // 204 No Content if no incidents are found
        }
    }

}
