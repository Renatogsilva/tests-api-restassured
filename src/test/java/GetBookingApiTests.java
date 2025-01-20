import apis.GetBookingApi;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetBookingApiTests {

    private GetBookingApi getBookingApi;

    @BeforeClass
    public void initApi(){
        this.getBookingApi = new GetBookingApi();
    }

    @Test(description = "Basic HTTP status check for get bookings ids API")
    public void validateStatusCodeForGetAllBookings() {
        var getBookingIdsResponse = this.getBookingApi.getAllBookingIds()
                .then().assertThat().statusCode(200);
    }

    @Test(description = "Basic HTTP status check for get booking by ID API")
    public void validateStatusCodeForGetBookingById() {
        var getBookingByIdApiResponse = this.getBookingApi.getBookingById(10)
                .then().assertThat().statusCode(200);
    }
}