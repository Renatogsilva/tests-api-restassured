import apis.CreateBookingApi;
import apis.DeleteBookingApi;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.ApiRequestHelper;

public class DeleteBookingApiTests {
    private DeleteBookingApi deleteBookingApi;

    @BeforeClass
    public void initApi(){
        deleteBookingApi = new DeleteBookingApi();
    }

    @Test(description = "Delete an existing booking by Id")
    public void deleteBookingById(){
        var bodyCreate = ApiRequestHelper.getCreateBookingApiRequest("Lamine", "Yamal",
                1890, true, "Nothing else", "2025-01-19", "2025-01-20");

        CreateBookingApi createBookingApi = new CreateBookingApi();

        var createBookingApiResponse = createBookingApi
                .createBooking(bodyCreate)
                .then().assertThat().statusCode(200)
                .and().body("bookingid", Matchers.is(Matchers.not(Matchers.equalTo(0))));

        Integer bookingId = createBookingApiResponse.extract().path("bookingid");

        var deleteBookingApiResponse = this.deleteBookingApi.deleteBookingById(bookingId, "admin", "password123")
                .then().assertThat().statusCode(201);
    }
}
