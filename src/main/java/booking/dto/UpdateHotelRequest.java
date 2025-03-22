package booking.dto;

import lombok.Data;

@Data
public class UpdateHotelRequest {
    private String hotelName;
    private String hotelAddress;
    private boolean status ;
    private Integer rate;
    private Long addressId;
}
