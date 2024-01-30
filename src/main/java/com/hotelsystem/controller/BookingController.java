package com.hotelbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.model.BookingDetails;
import com.hotelbooking.model.BookingRequest;
import com.hotelbooking.service.BookingServiceImpl;

@RestController
@RequestMapping("/hotelrequests")
public class BookingController {

	@Autowired
	BookingServiceImpl bookingService;

//	private Gson gson = new Gson();

	@PostMapping("/createbooking")
	public String saveRecords(@RequestBody BookingRequest bookingRequest) {
		// TODO: process POST request
		String result = null;
		result = bookingService.createBooking(bookingRequest);

		return result;
	}

	@GetMapping("/viewbookingdetails")
	public ResponseEntity<?> getBookingDetails(@RequestParam String bookingId) {

		BookingDetails bookingDetails = bookingService.viewBooking(bookingId);
//		String json = gson.toJson(bookingDetails);
		if (bookingDetails != null) {
			return ResponseEntity.ok(bookingDetails);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking Details not found.");
		}

	}

	@DeleteMapping("/deletebooking")
	public String DeleteRecord(String bookingId) {

		return bookingService.deleteBooking(bookingId);

	}

}

