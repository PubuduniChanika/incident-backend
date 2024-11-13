package com.SecurityGuide.SecurityGuide.mapper;

import com.SecurityGuide.SecurityGuide.dto.IncidentReportDTO;
import com.SecurityGuide.SecurityGuide.dto.ReqRes;
import com.SecurityGuide.SecurityGuide.dto.SystemUserDto;
import com.SecurityGuide.SecurityGuide.entity.IncidentReport;
import com.SecurityGuide.SecurityGuide.entity.SystemUsers; // Adjust the package if necessary


import java.util.List;
import java.util.stream.Collectors;

public class IncidentReportMapper {

    public static IncidentReportDTO toDto(IncidentReport entity) {
        List<SystemUserDto> systemUserDtoList = entity.getSystemUsers().stream()
                .map(SystemUserMapper::systemUserToDto)
                .collect(Collectors.toList());

        return new IncidentReportDTO(
                entity.getId(),
                entity.getCallerName(),
                entity.getCallTime(),
                entity.getCallerContactInfo(),
                entity.getIncidentNature(),
                entity.getEquipmentOrPersonsInvolved(),
                entity.getLocationOfInvolved(),
                entity.getIncidentDetection(),
                systemUserDtoList

        );
    }

    public static IncidentReportDTO toNewIncidentDto(IncidentReport entity) {
        return new IncidentReportDTO(
                entity.getId(),
                entity.getCallerName(),
                entity.getCallTime(),
                entity.getCallerContactInfo(),
                entity.getIncidentNature(),
                entity.getEquipmentOrPersonsInvolved(),
                entity.getLocationOfInvolved(),
                entity.getIncidentDetection()
        );
    }

    public static IncidentReport toEntity(IncidentReportDTO dto) {
        IncidentReport incidentReport = new IncidentReport();
        incidentReport.setId(dto.getId());
        incidentReport.setCallerName(dto.getCallerName());
        incidentReport.setCallTime(dto.getCallTime());
        incidentReport.setCallerContactInfo(dto.getCallerContactInfo());
        incidentReport.setIncidentNature(dto.getIncidentNature());
        incidentReport.setEquipmentOrPersonsInvolved(dto.getEquipmentOrPersonsInvolved());
        incidentReport.setLocationOfInvolved(dto.getLocationOfInvolved());
        incidentReport.setIncidentDetection(dto.getIncidentDetection());
        return incidentReport;
    }
}
