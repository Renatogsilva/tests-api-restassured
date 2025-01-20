package apis;

import constants.ApiPaths;
import http.BaseApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class CreateBookingApi extends BaseApi {
    public CreateBookingApi() {
        super();
        super.loggAllRequestData()
                .loggAllResponseData();
        super.setContentType(ContentType.JSON);
    }

    public Response createBooking(Map<String, Object> requestBody) {
        return this.getCreateBookingApiResponse(requestBody);
    }

    public Response createBooking(CreateBookingApi requestBody) {
        return this.getCreateBookingApiResponse(requestBody);
    }

    private Response getCreateBookingApiResponse(Object createBookingPayload) {
        super.setBasePath(ApiPaths.CREATE_BOOKING.getApiPath());
        super.setRequestBody(createBookingPayload);
        return super.sendRequest(ApiPaths.CREATE_BOOKING.getHttpMethodType());
    }
}
