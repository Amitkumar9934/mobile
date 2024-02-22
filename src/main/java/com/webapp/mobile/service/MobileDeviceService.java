package com.webapp.mobile.service;

import com.webapp.mobile.dto.MobileDeviceDto;

import java.util.List;

public interface MobileDeviceService {
    MobileDeviceDto createMobileDevice(MobileDeviceDto mobileDeviceDto, long mobileId);

    List<MobileDeviceDto> getMobileDeviceById(long mobileid);
}
