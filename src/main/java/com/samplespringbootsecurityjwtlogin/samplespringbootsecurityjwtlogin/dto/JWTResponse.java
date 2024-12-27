package com.samplespringbootsecurityjwtlogin.samplespringbootsecurityjwtlogin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class JWTResponse {
    private String token;
    private String username;
}