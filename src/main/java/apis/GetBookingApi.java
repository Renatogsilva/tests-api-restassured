package apis;

import constants.ApiPaths;
import http.BaseApi;
import io.restassured.response.Response;

public class GetBookingApi extends BaseApi {

    public GetBookingApi() {
        super();
        super.loggAllRequestData()
                .loggAllResponseData();
    }

    public Response getAllBookingIds(){
        super.setBasePath(ApiPaths.GET_BOOKING_IDS.getApiPath());
        return super.sendRequest(ApiPaths.GET_BOOKING_IDS.getHttpMethodType());
    }

    public Response getBookingById(int bookingId){
        super.setBasePath(ApiPaths.GET_BOOKING.getApiPath());
        super.setPathParam("bookingId", bookingId);
        return super.sendRequest(ApiPaths.GET_BOOKING_IDS.getHttpMethodType());
    }
}
