package com.SecurityGuide.SecurityGuide.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncidentReportDTO {

    private Long id;
    private String callerName;
    private LocalDate callTime;
    private String callerContactInfo;
    private String incidentNature;
    private String equipmentOrPersonsInvolved;
    private String locationOfInvolved;
    private String incidentDetection;
}
