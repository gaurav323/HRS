package com.hotelbooking.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hotelbooking.dao.BookingDaoImpl;
import com.hotelbooking.model.BookingDetails;
import com.hotelbooking.model.BookingRequest;

public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingDaoImpl bookingDao;

	@Override
	public String createBooking(BookingRequest bookingRequest) {
		// TODO Auto-generated method stub
		if (bookingRequest != null) {
			bookingDao.saveBooking(bookingRequest);
			// additional logic or manipulation also we can add.
			return "Booking request created succesfully.";
		} else {
			// We can throw exception also.
			return "Something wrong with your booking Request";
		}

	}

	@Override
	public BookingDetails viewBooking(String bookingId) {
		// TODO Auto-generated method stub
		if (!bookingId.isEmpty() && bookingId.length() != 0) {
			return bookingDao.getBookingDetails(bookingId);
		} else {
			return null;
			// We can throw exception also.
		}
	}

	@Override
	public String deleteBooking(String bookingId) {
		// TODO Auto-generated method stub
		if (!bookingId.isEmpty() && bookingId.length() != 0) {
			bookingDao.deleteBooking(bookingId);
			return "Booking request deleted successfully";
		} else {
			return "Something went wrong";
			// exception handling also we can do.
		}
	}

}
