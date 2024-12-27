package com.samplespringbootsecurityjwtlogin.samplespringbootsecurityjwtlogin.services;

import com.samplespringbootsecurityjwtlogin.samplespringbootsecurityjwtlogin.dto.JWTResponse;
import com.samplespringbootsecurityjwtlogin.samplespringbootsecurityjwtlogin.dto.UserDTO;

public interface AuthService {

    JWTResponse login(UserDTO userDTO);

}
