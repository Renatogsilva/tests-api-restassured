package apis;

import constants.ApiPaths;
import domain.response.Booking;
import domain.response.BookingResponse;
import http.BaseApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class UpdateBookingApi extends BaseApi {

    public UpdateBookingApi() {
        super();
        super.loggAllRequestData()
                .loggAllResponseData();
        super.setContentType(ContentType.JSON);
    }


    public Response updateBooking(Map<String, Object> requestBody, int bookingId, String username, String password) {
        return this.getUpdateBookingApiResponse(requestBody, bookingId, username, password);
    }

    public Response updateBooking(BookingResponse requestBody, int bookingId, String username, String password) {
        return this.getUpdateBookingApiResponse(requestBody, bookingId, username, password);
    }

    private Response getUpdateBookingApiResponse(Object createBookingPayload, int bookingId, String username, String password) {
        super.setBasePath(ApiPaths.UPDATE_BOOKING.getApiPath());
        super.setRequestBody(createBookingPayload);
        super.setPathParam("bookingId", bookingId);
        super.setBasicAuth(username, password);
        return super.sendRequest(ApiPaths.UPDATE_BOOKING.getHttpMethodType());
    }
}
