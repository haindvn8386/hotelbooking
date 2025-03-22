package booking.service;

import booking.dto.CreateHotelRequest;
import booking.dto.UpdateHotelRequest;
import booking.entity.Address;
import booking.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import booking.repository.HotelRepository;

import java.util.List;

@Service
public class HotelService   {

    @Autowired
    HotelRepository hotelRepository;

    public List<Hotel> findHotelsByRateAndStatus(Integer rate, Boolean status) {
        List<Hotel> result = hotelRepository.findHotelsByRateAndStatus(rate, status);
        return result.isEmpty() ? null : result;
    }

    public Hotel findHotelById(Long id) {
        return hotelRepository.findHotelById(id);
    }

    public Hotel createHotel(CreateHotelRequest request) {
        Hotel hotel = new Hotel();
        hotel.setHotelName(request.getHotelName());
        hotel.setRate(request.getRate());

        // Tạo đối tượng Address từ request
        Address address = new Address();
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setProvince(request.getProvince());
        address.setNation(request.getNation());
        address.setVersion(request.getVersion());

        // Gán Address vào Hotel
        hotel.setAddress(address);
        // Lưu Hotel (cả Hotel và Address sẽ được lưu do cascade = CascadeType.ALL)
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(Long id, UpdateHotelRequest request) {
        Hotel hotel = hotelRepository.findHotelById(id);
        if(hotel == null) {
            return null;
        }
        hotel.setHotelName(request.getHotelName());
        //hotel.setAddress_id(request.getAddressId());
        hotel.setRate(request.getRate());
        return hotelRepository.save(hotel);
    }

    public Hotel disableHotel(Long id) {
        Hotel hotel = hotelRepository.findHotelById(id);
        if(hotel == null) {
            return null;
        }
        hotel.setStatus(false);
        return hotelRepository.save(hotel);
    }

}
