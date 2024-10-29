package com.SecurityGuide.SecurityGuide.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "incident_report")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncidentReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "caller_name", nullable = false)
    private String callerName;

    @Column(name = "call_time", nullable = false)
    private LocalDateTime callTime;

    @Column(name = "caller_contact_info")
    private String callerContactInfo;

    @Column(name = "incident_nature", nullable = false)
    private String incidentNature;

    @Column(name = "equipment_or_persons_involved")
    private String equipmentOrPersonsInvolved;

    @Column(name = "location_of_involved")
    private String locationOfInvolved;

    @Column(name = "incident_detection")
    private String incidentDetection;
}
