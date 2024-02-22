package com.webapp.mobile.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mobileDevices")
public class MobileDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deviceID;

    private String model;
    private String manufacturer;
    private String os;
    @ManyToOne
    @JoinColumn(name = "mobile_id")
    private Mobile mobile;
}
