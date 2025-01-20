package apis;

import constants.ApiPaths;
import http.BaseApi;
import io.restassured.response.Response;

public class DeleteBookingApi extends BaseApi {

    public DeleteBookingApi() {
        super();
        super.loggAllRequestData()
                .loggAllResponseData();
    }

    public Response deleteBookingById(int bookingId, String username, String password) {
        super.setBasePath(ApiPaths.DELETE_BOOKING.getApiPath());
        super.setPathParam("bookingId", bookingId);
        super.setBasicAuth(username, password);
        return super.sendRequest(ApiPaths.DELETE_BOOKING.getHttpMethodType());
    }
}
