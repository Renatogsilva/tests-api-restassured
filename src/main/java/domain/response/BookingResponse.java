package domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class BookingResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("booking")
    private Booking booking;

    @JsonProperty("bookingid")
    private int bookingId;
}
