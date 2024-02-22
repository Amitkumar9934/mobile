package com.webapp.mobile.service.impl;

import com.webapp.mobile.dto.MobileDto;
import com.webapp.mobile.entity.Mobile;
import com.webapp.mobile.exception.RNFException;
import com.webapp.mobile.repository.MobileRepository;
import com.webapp.mobile.service.MobileService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MobileServiceimpl implements MobileService {
    private MobileRepository mobileRepository;

    public MobileServiceimpl(MobileRepository mobileRepository) {
        this.mobileRepository = mobileRepository;
    }

    @Override
    public MobileDto savemobile(MobileDto mobileDto) {
        Mobile mobile = EntityTodto(mobileDto);
        Mobile saved = mobileRepository.save(mobile);
        MobileDto dto = DtoToEntity(saved);

        return dto;
    }

    @Override
    public MobileDto readById(long id) {
        Mobile mobile = mobileRepository.findById(id).orElseThrow(() -> new RNFException("record not found by id" + id));
        MobileDto dto = DtoToEntity(mobile);
        return dto;
    }

    @Override
    public List<MobileDto> readall(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Mobile> page = mobileRepository.findAll(pageable);
        List<Mobile> mobiles = page.getContent();
        List<MobileDto> dtos = mobiles.stream().map(p -> DtoToEntity(p)).collect(Collectors.toList());
        return dtos;
    }

    Mobile EntityTodto(MobileDto mobileDto){
        Mobile mobile = new Mobile();
        mobile.setName(mobileDto.getName());
        mobile.setPrice(mobileDto.getPrice());
        return mobile;
    }
    MobileDto DtoToEntity(Mobile mobile){
        MobileDto mobileDto = new MobileDto();
        mobileDto.setId(mobile.getId());
        mobileDto.setName(mobile.getName());
        mobileDto.setPrice(mobile.getPrice());
        return mobileDto;
    }
}
