package com.hotelbooking.service;

import com.hotelbooking.model.BookingDetails;
import com.hotelbooking.model.BookingRequest;

public interface BookingService {

	public String createBooking(BookingRequest bookingRequest);

	public BookingDetails viewBooking(String bookingId);

	public String deleteBooking(String bookingId);

}

