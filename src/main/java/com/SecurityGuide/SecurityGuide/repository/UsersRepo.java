package com.SecurityGuide.SecurityGuide.repository;

import com.SecurityGuide.SecurityGuide.entity.IncidentReport;
import com.SecurityGuide.SecurityGuide.entity.SystemUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<SystemUsers,Integer> {
    Optional<SystemUsers> findByEmail(String email);

    @Query("SELECT u.id FROM SystemUsers u WHERE u.email = :email")
    Integer findIdByEmail(@Param("email") String email);
}
