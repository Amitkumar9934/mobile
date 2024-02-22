package com.webapp.mobile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobileDeviceDto {
    private String model;
    private String manufacturer;
    private String os;
}
