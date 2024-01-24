package com.webapp.mobile.repository;

import com.webapp.mobile.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepository extends JpaRepository<Mobile,Long> {
}
