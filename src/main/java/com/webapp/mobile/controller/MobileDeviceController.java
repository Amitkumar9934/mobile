package com.webapp.mobile.controller;

import com.webapp.mobile.dto.MobileDeviceDto;
import com.webapp.mobile.service.MobileDeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mobiledevices")
public class MobileDeviceController     {

    private MobileDeviceService mobileDeviceService;

    public MobileDeviceController(MobileDeviceService mobileDeviceService) {
        this.mobileDeviceService = mobileDeviceService;
    }
    //http://localhost:8080/api/mobiledevices?mobileId=4
    @PostMapping
    public ResponseEntity<MobileDeviceDto> createMobileDevice(@RequestBody MobileDeviceDto mobileDeviceDto,
                                                              @RequestParam long mobileId) {
        MobileDeviceDto dtos = mobileDeviceService.createMobileDevice(mobileDeviceDto,mobileId);
        return  new ResponseEntity<>(dtos, HttpStatus.CREATED);
    }
    //http://localhost:8080/api/mobiledevices/mobile?mobileid=4
    @GetMapping("/mobile")
    public List<MobileDeviceDto> getMobileDeviceById(@RequestParam long mobileid) {
        List<MobileDeviceDto> dtos = mobileDeviceService.getMobileDeviceById(mobileid);
        return dtos;
    }
}
