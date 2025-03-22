package booking.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CreateHotelRequest {
    private String hotelName;
    private Integer rate;

    private String street ;
    private String city;
    private String province;
    private String nation;
    private Integer version;

}
