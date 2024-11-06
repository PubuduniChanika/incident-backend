package com.SecurityGuide.SecurityGuide.dto;

import com.SecurityGuide.SecurityGuide.entity.SystemUsers;
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



}
