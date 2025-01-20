import apis.CreateBookingApi;
import apis.UpdateBookingApi;
import domain.response.Booking;
import domain.response.BookingResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.ApiRequestHelper;

public class UpdateBookingApiTests {
    private UpdateBookingApi updateBookingApi;

    @BeforeClass
    public void initApi(){
        this.updateBookingApi = new UpdateBookingApi();
    }

    @Test(description = "update a newly created booking and validate HTTP status code")
    public void updateAndValidateStatusCode() {
        var bodyCreate = ApiRequestHelper.getCreateBookingApiRequest("Lamine", "Yamal",
                1890, true, "Nothing else", "2025-01-19", "2025-01-20");

        CreateBookingApi createBookingApi = new CreateBookingApi();

        var createBookingApiResponse = createBookingApi
                .createBooking(bodyCreate)
                .then().assertThat().statusCode(200)
                .and().body("bookingid", Matchers.is(Matchers.not(Matchers.equalTo(0))));

        Integer bookingId = createBookingApiResponse.extract().path("bookingid");

        bodyCreate.replace("firstname", "Alvaro");
        bodyCreate.replace("lastname", "Morata");

        var updateBookingApi = this.updateBookingApi
                .updateBooking(bodyCreate, bookingId, "admin", "password123")
                .then().assertThat().statusCode(200)
                .and().body("bookingid", Matchers.is(Matchers.not(Matchers.equalTo(0))));
    }
}
