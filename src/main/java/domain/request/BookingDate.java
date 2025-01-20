package domain.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookingDate implements Serializable {
    private static final long serialVersionUID = 1L;

    private String checkin;
    private String checkout;
}
