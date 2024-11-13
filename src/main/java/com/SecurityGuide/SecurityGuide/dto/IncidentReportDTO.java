package com.SecurityGuide.SecurityGuide.dto;

import com.SecurityGuide.SecurityGuide.entity.SystemUsers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncidentReportDTO {

    private Long id;
    private String callerName;
    private LocalDate callTime; // Use LocalDateTime if both date and time are relevant
    private String callerContactInfo;
    private String incidentNature;
    private String equipmentOrPersonsInvolved;
    private String locationOfInvolved;
    private String incidentDetection;
    private List<SystemUserDto> systemUsers;

    public IncidentReportDTO(Long id, String callerName, LocalDate callTime, String callerContactInfo, String incidentNature, String equipmentOrPersonsInvolved, String locationOfInvolved, String incidentDetection) {
        this.id = id;
        this.callerName = callerName;
        this.callTime = callTime;
        this.callerContactInfo = callerContactInfo;
        this.incidentNature = incidentNature;
        this.equipmentOrPersonsInvolved = equipmentOrPersonsInvolved;
        this.locationOfInvolved = locationOfInvolved;
        this.incidentDetection = incidentDetection;
    }
}
