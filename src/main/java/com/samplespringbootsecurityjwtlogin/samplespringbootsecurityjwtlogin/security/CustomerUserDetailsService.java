package com.samplespringbootsecurityjwtlogin.samplespringbootsecurityjwtlogin.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        if(userRepository.findByUsername(username).isPresent()){
            user = userRepository.findByUsername(username).get();
            return new org.springframework.security.core.userdetails.User(user.getEmailId(),
                    user.getPassword(),
                    mapRolesToAuthorities(user.getRoles()));
        }
        else {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<Roles> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .toList();
    }
}