package com.qsp.hotelmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hotelmanagementsystem.dto.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Integer>{

}
