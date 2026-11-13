package com.project.uber.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    // Registration-time flags for the companion user_details row
    private Boolean isElectrician;
    private Boolean isCustomer;
}