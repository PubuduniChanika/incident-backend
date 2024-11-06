package com.SecurityGuide.SecurityGuide.repository;

import com.SecurityGuide.SecurityGuide.entity.IncidentReport;
import com.SecurityGuide.SecurityGuide.entity.SystemUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<SystemUsers,Integer> {
    Optional<SystemUsers> findByEmail(String email);

}
