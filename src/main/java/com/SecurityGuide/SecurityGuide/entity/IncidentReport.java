package com.SecurityGuide.SecurityGuide.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
    private LocalDate callTime;

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

    @ManyToMany
    @JoinTable(
            name = "incident_user",
            joinColumns = @JoinColumn(name = "incident_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<SystemUsers> systemUsers;

}
