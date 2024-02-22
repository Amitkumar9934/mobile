package com.webapp.mobile.service;

import com.webapp.mobile.dto.MobileDto;

import java.util.List;

public interface MobileService {
    MobileDto savemobile(MobileDto mobileDto);

    MobileDto readById(long id);

    List<MobileDto> readall(int pageNo, int pageSize, String sortBy);
}
