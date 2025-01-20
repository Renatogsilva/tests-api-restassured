import apis.CreateBookingApi;
import domain.request.BookingDate;
import domain.request.BookingRequest;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.ApiRequestHelper;

import java.util.HashMap;
import java.util.Map;

public class CreateBookingApiTests {
    private CreateBookingApi createBookingApi;

    @BeforeClass
    public void initApi() {
        this.createBookingApi = new CreateBookingApi();
    }

    @Test(description = "Create a new booking and validate HTTP status code")
    public void createAndValidateStatusCode() {
        var body = ApiRequestHelper.getCreateBookingApiRequest("Lamine", "Yamal",
                1890, true, "Nothing else", "2025-01-19", "2025-01-20");

        var createBookingApiResponse = this.createBookingApi
                .createBooking(body)
                .then().assertThat().statusCode(200)
                .and().body("bookingid", Matchers.is(Matchers.not(Matchers.equalTo(0))));
    }
}
