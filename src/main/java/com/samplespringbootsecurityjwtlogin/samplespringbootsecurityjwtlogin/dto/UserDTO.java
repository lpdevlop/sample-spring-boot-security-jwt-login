package com.samplespringbootsecurityjwtlogin.samplespringbootsecurityjwtlogin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDTO {

    private Integer id;

    private String CreationDate;

    private Integer otpCode;

    private String emailId;

    private String status;


    private String personalEmail;

    private String mobileNumber;

    private String phone;
    private String type;

    private String password;

    private String firstName;

    private String dob;

    private String gender;

    private String address;

    private String branchCode;

    private String lastName;

    private String nic;

    private Boolean active;

    private Instant modifiedDate;

    private Integer createdBy;

}