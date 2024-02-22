package com.webapp.mobile.controller;


import com.webapp.mobile.dto.MobileDto;
import com.webapp.mobile.entity.Mobile;
import com.webapp.mobile.service.MobileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mobile")
public class MobileController {

    private MobileService mobileService;

    public MobileController(MobileService mobileService) {
        this.mobileService = mobileService;
    }

    @PostMapping
    public ResponseEntity<MobileDto> savemobile(@RequestBody MobileDto mobileDto){
        MobileDto mobiles = mobileService.savemobile(mobileDto);
        return new ResponseEntity<>(mobiles, HttpStatus.CREATED);
    }
    @GetMapping("/byId")
    public  ResponseEntity<MobileDto> readById(@RequestParam long id){
        MobileDto mobile = mobileService.readById(id);
        return new ResponseEntity<>(mobile,HttpStatus.OK);
    }
    @GetMapping
    public List<MobileDto> readAll(
            @RequestParam(name="pageNo",required = false,defaultValue = "0") int pageNo,
            @RequestParam(name="pageSize",required = false,defaultValue = "0") int pageSize,
            @RequestParam(name="sortBy",required = false,defaultValue = "id") String sortBy
            ){
        List<MobileDto> dtos = mobileService.readall(pageNo,pageSize,sortBy);
        return dtos;
    }
}
