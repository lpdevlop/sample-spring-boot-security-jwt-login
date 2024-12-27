package com.samplespringbootsecurityjwtlogin.samplespringbootsecurityjwtlogin.security;

import com.samplespringbootsecurityjwtlogin.samplespringbootsecurityjwtlogin.constant.Constant;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AccessControlService {


    public boolean hasSuperAdminRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals(Constant.ROLE_SUPER_ADMIN));
    }

    public boolean hasAdminOrHigherRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals(Constant.ROLE_SUPER_ADMIN) || auth.getAuthority().equals(Constant.ROLE_ADMIN));
    }

    public boolean hasEmployeeOrHigherRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals(Constant.ROLE_SUPER_ADMIN) || auth.getAuthority().equals(Constant.ROLE_ADMIN) || auth.getAuthority().equals(Constant.ROLE_ADMIN));
    }

}