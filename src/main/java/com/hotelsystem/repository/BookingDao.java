package com.hotelbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.entity.BookingEntity;

public interface BookingDao extends JpaRepository<BookingEntity, Long> {

}

