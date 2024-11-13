package com.SecurityGuide.SecurityGuide.service;

import com.SecurityGuide.SecurityGuide.entity.SystemUsers;
import com.SecurityGuide.SecurityGuide.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SystemUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find the user by email (username in this case)
        SystemUsers user = usersRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));

        // You can now directly return the user object as UserDetails
        return user;
    }

    public Integer getUserIdByEmail(String email) {

        SystemUsers user = usersRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return user.getId();  // Directly returning the user ID
    }

}
