package com.SecurityGuide.SecurityGuide.repository;

import com.SecurityGuide.SecurityGuide.entity.IncidentReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentReportRepository extends JpaRepository<IncidentReport, Long> {

    Page<IncidentReport> findAll(Pageable pageable);

    @Query("SELECT i FROM IncidentReport i " +
            "JOIN i.systemUsers su " +
            "WHERE (" +
            "LOWER(i.callerName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(i.callerContactInfo) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(i.incidentNature) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(i.equipmentOrPersonsInvolved) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(i.locationOfInvolved) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(i.incidentDetection) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "DATE_FORMAT(i.callTime, '%m/%d/%Y') = :searchTerm OR " +
            "LOWER(su.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))" +
            ")")
    Page<IncidentReport> findBySearchTerm(@Param("searchTerm") String searchTerm, Pageable pageable);

    @Query("SELECT i FROM IncidentReport i " +
            "JOIN i.systemUsers su " +
            "WHERE su.id = :userId AND (" +
            "LOWER(i.callerName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(i.callerContactInfo) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(i.incidentNature) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(i.equipmentOrPersonsInvolved) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(i.locationOfInvolved) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(i.incidentDetection) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "DATE_FORMAT(i.callTime, '%m/%d/%Y') = :searchTerm OR " +
            "LOWER(su.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))" +
            ")")
    Page<IncidentReport> findBySearchTermAndUser_Id(@Param("searchTerm") String searchTerm,
                                                    @Param("userId") Integer userId,
                                                    Pageable pageable);
    // Query to fetch all incident reports filtered by user ID
    @Query("SELECT i FROM IncidentReport i JOIN i.systemUsers su WHERE su.id = :userId")
    Page<IncidentReport> findAllByUser_Id(@Param("userId") Integer userId, Pageable pageable);
}
