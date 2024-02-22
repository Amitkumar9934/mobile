package com.webapp.mobile.service.impl;

import com.webapp.mobile.dto.MobileDeviceDto;
import com.webapp.mobile.entity.Mobile;
import com.webapp.mobile.entity.MobileDevice;
import com.webapp.mobile.exception.RNFException;
import com.webapp.mobile.repository.MobileDeviceRepository;
import com.webapp.mobile.repository.MobileRepository;
import com.webapp.mobile.service.MobileDeviceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MobileDeviceServiceImpl implements MobileDeviceService {

    private MobileDeviceRepository mobileDeviceRepository;
    private MobileRepository mobileRepository;

    private ModelMapper modelMapper;

    public MobileDeviceServiceImpl(MobileDeviceRepository mobileDeviceRepository, MobileRepository mobileRepository, ModelMapper modelMapper) {
        this.mobileDeviceRepository = mobileDeviceRepository;
        this.mobileRepository = mobileRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MobileDeviceDto createMobileDevice(MobileDeviceDto mobileDeviceDto, long mobileId) {

        Mobile mobile = mobileRepository.findById(mobileId).orElseThrow(
                () -> new RNFException("record not found by id" + mobileId));
        MobileDevice md = mapToEntity(mobileDeviceDto);
        md.setMobile(mobile);
        MobileDevice saved = mobileDeviceRepository.save(md);
        MobileDeviceDto dto = mapToDto(saved);
        return dto;
    }

    @Override
    public List<MobileDeviceDto> getMobileDeviceById(long mobileid) {
        List<MobileDevice> dto = mobileDeviceRepository.findBymobileId(mobileid);
        return dto.stream().map(a->mapToDto(a)).collect(Collectors.toList());
    }

    MobileDevice mapToEntity(MobileDeviceDto mobileDeviceDto){
        MobileDevice mobile = modelMapper.map(mobileDeviceDto, MobileDevice.class);
        return  mobile;
    }
    MobileDeviceDto mapToDto(MobileDevice mobileDevice) {
        MobileDeviceDto mobiles = modelMapper.map(mobileDevice, MobileDeviceDto.class);
        return mobiles;
    }

}
