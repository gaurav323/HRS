package com.hotelbooking.main;

import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotelbooking.dao.BookingDaoImpl;
import com.hotelbooking.model.BookingDetails;
import com.hotelbooking.model.BookingRequest;
import com.hotelbooking.service.BookingServiceImpl;

@SpringBootTest
class HotelBookingSystemApplicationTests {

	@Mock
    private BookingDaoImpl bookingDAO;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Test
    public void testCreateBooking() {
        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setGuestName("shyam");
        bookingRequest.setGuestEmail("shyam@example.com");
        bookingRequest.setHotelName("Test_Hotel");
        bookingRequest.setCheckInDate(LocalDate.now());
        bookingRequest.setCheckOutDate(LocalDate.now().plusDays(3));
        bookingRequest.setNoOfGuests(2);

        bookingService.createBooking(bookingRequest);

        // Verify that the saveBooking method in bookingDAO was called
        Mockito.verify(bookingDAO).saveBooking(bookingRequest);
    }

    @Test
    public void testViewBooking() {
        String bookingId = "123";
        BookingDetails mockBookingDetails = new BookingDetails();
        mockBookingDetails.setBookingId(bookingId);
        mockBookingDetails.setGuestName("Mock Guest");
        mockBookingDetails.setGuestEmail("mock@example.com");
        mockBookingDetails.setHotelName("Mock Hotel");
        mockBookingDetails.setCheckInDate(LocalDate.now());
        mockBookingDetails.setCheckOutDate(LocalDate.now().plusDays(5));
        mockBookingDetails.setNumberOfGuests(3);
        mockBookingDetails.setTotalCost(500.0);
        when(bookingDAO.getBookingDetails(bookingId)).thenReturn(mockBookingDetails);
        BookingDetails result = bookingService.viewBooking(bookingId);
        Mockito.verify(bookingDAO).getBookingDetails(bookingId);
        assertEquals(mockBookingDetails, result);
    }

	

}

