package com.project.uber.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto {

    private Integer id;
    private Integer userId;
    private Boolean isElectrician;
    private Boolean isCustomer;
    private Boolean isActive;
    private Boolean isDeleted;
    private LocalDateTime createdAt;
}
