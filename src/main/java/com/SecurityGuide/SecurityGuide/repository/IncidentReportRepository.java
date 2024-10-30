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

    @Query("SELECT i FROM IncidentReport i WHERE " +
            "LOWER(i.callerName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(i.incidentNature) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    Page<IncidentReport> findBySearchTerm(@Param("searchTerm") String searchTerm, Pageable pageable);
}
