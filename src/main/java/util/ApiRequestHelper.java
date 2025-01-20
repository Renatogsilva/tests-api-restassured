package util;

import domain.request.BookingDate;
import domain.request.BookingRequest;

import java.util.HashMap;
import java.util.Map;

public class ApiRequestHelper {

    public static Map<String, Object> getCreateBookingApiRequest(String firstName, String lastName, int totalPrice,
                                                                 boolean depositPaid, String additionalNeeds,
                                                                 String checkin, String checkout) {

        Map<String, Object> body = new HashMap<>();
        body.put("firstname", firstName);
        body.put("lastname", lastName);
        body.put("totalprice", totalPrice);
        body.put("depositpaid", depositPaid);
        body.put("additionalneeds", additionalNeeds);
        //Create booking date map
        Map<String, Object> bodyBookingDates = new HashMap<>();
        bodyBookingDates.put("checkin", checkin);
        bodyBookingDates.put("checkout", checkout);

        body.put("bookingdates", bodyBookingDates);

        return body;
    }

    public static BookingRequest getCreateBookingApiResponse(String firstName, String lastName, int totalPrice,
                                                             boolean depositPaid, String additionalNeeds,
                                                             String checkin, String checkout) {

        BookingRequest bookingRequest = new BookingRequest();
        BookingDate bookingDate = new BookingDate();

        bookingRequest.setFirstName(firstName);
        bookingRequest.setLastName(lastName);
        bookingRequest.setTotalPrice(totalPrice);
        bookingRequest.setBookingDates(bookingDate);
        bookingRequest.setAdditionalNeeds("Nothing else");
        bookingRequest.setDepositPaid(false);

        bookingDate.setCheckin("2025-01-18");
        bookingDate.setCheckout("2025-01-19");

        return bookingRequest;
    }
}
