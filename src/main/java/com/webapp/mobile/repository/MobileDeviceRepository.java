package com.webapp.mobile.repository;

import com.webapp.mobile.entity.MobileDevice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MobileDeviceRepository extends JpaRepository<MobileDevice,Integer> {
    List<MobileDevice> findBymobileId(long mobileid);
}
