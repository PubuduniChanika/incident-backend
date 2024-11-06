package com.SecurityGuide.SecurityGuide.mapper;

import com.SecurityGuide.SecurityGuide.dto.ReqRes;
import com.SecurityGuide.SecurityGuide.dto.SystemUserDto;
import com.SecurityGuide.SecurityGuide.entity.SystemUsers;

public class SystemUserMapper {

    // Convert SystemUsers entity to ReqRes DTO
    public static ReqRes toDto(SystemUsers systemUser) {
        ReqRes dto = new ReqRes();
        dto.setName(systemUser.getName());
        dto.setEmail(systemUser.getEmail());
        dto.setPassword(systemUser.getPassword());
        dto.setDesignation(systemUser.getDesignation());
        dto.setRole(systemUser.getRole());


        return dto;
    }

    public static SystemUserDto systemUserToDto(SystemUsers systemUser) {
        SystemUserDto dto = new SystemUserDto();
        dto.setId(systemUser.getId());
        dto.setName(systemUser.getName());
        return dto;
    }

    // Convert ReqRes DTO to SystemUsers entity
    public static SystemUsers toEntity(ReqRes dto) {
        SystemUsers systemUser = new SystemUsers();
        systemUser.setName(dto.getName());
        systemUser.setEmail(dto.getEmail());
        systemUser.setPassword(dto.getPassword());
        systemUser.setDesignation(dto.getDesignation());
        systemUser.setRole(dto.getRole());

        return systemUser;
    }
}
