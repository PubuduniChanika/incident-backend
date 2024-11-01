package com.SecurityGuide.SecurityGuide.dto;

import com.SecurityGuide.SecurityGuide.entity.SystemUsers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncidentReportDTO {

    private Long id;
    private String callerName;
    private LocalDate callTime;
    private String callerContactInfo;
    private String incidentNature;
    private String equipmentOrPersonsInvolved;
    private String locationOfInvolved;
    private String incidentDetection;
    private List<SystemUsers> systemUsersList;
}
