package domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import domain.request.BookingDate;
import lombok.Data;

import java.io.Serializable;

@Data
public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("lastname")
    private String lastName;
    @JsonProperty("totalprice")
    private int totalPrice;
    @JsonProperty("depositpaid")
    private boolean depositPaid;
    @JsonProperty("bookingdates")
    private BookingDate bookingDates;
    @JsonProperty("additionalneeds")
    private String additionalNeeds;
}
