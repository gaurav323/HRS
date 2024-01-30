package com.hotelbooking.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotelbooking.entity.BookingEntity;
import com.hotelbooking.model.BookingDetails;
import com.hotelbooking.model.BookingRequest;

@Repository
public class BookingDaoImpl {

	@Autowired
	private BookingDao bookingDAO;

	public void saveBooking(BookingRequest bookingRequest) {
		BookingEntity bookingEntity = new BookingEntity();
		// Map fields from BookingRequest to BookingEntity
		// Save the entity to the database
		bookingEntity.setCheckInDate(bookingRequest.getCheckInDate());
		bookingEntity.setCheckOutDate(bookingRequest.getCheckOutDate());
		bookingEntity.setGuestEmail(bookingRequest.getGuestEmail());
		bookingEntity.setGuestName(bookingRequest.getGuestName());
		bookingEntity.setHotelName(bookingRequest.getHotelName());
		bookingEntity.setNoOfGuests(bookingRequest.getNoOfGuests());
		// totalCost calculation logic or manipulation.

		bookingDAO.save(bookingEntity);
	}

	public BookingDetails getBookingDetails(String bookingId) {
		Optional<BookingEntity> optionalBookingEntity = bookingDAO.findById(Long.parseLong(bookingId));

		if (optionalBookingEntity.isPresent()) {
			BookingEntity bookingEntity = optionalBookingEntity.get();

			BookingDetails bookingDetails = new BookingDetails();
			bookingDetails.setBookingId(String.valueOf(bookingEntity.getId()));
			bookingDetails.setCheckInDate(bookingEntity.getCheckInDate());
			bookingDetails.setCheckOutDate(bookingEntity.getCheckOutDate());
			bookingDetails.setGuestEmail(bookingEntity.getGuestEmail());
			bookingDetails.setGuestName(bookingEntity.getGuestName());
			bookingDetails.setHotelName(bookingEntity.getHotelName());
			bookingDetails.setNumberOfGuests(bookingEntity.getNoOfGuests());
			bookingDetails.setTotalCost(bookingEntity.getTotalCost());
			return bookingDetails;
		} else {
			return null; // we can throw an exception also
		}
	}

	public void deleteBooking(String bookingId) {

		bookingDAO.deleteById(Long.parseLong(bookingId));
	}
}

