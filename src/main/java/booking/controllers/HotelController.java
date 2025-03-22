package booking.controllers;

import booking.dto.CreateHotelRequest;
import booking.dto.ResponseDto;
import booking.dto.UpdateHotelRequest;
import booking.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import booking.service.HotelService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;


@RestController
@RequestMapping("/api/v1")
public class HotelController
{
    @Autowired
    HotelService hotelService;

    private static List<Hotel> hotels = new ArrayList<Hotel>();

    //1. create Hotel
    //Method: Post
    //url: /api/v1/hotels
    @PostMapping("/hotels")
    public Hotel createHotel(@RequestBody CreateHotelRequest request)
    {
        return hotelService.createHotel(request);
    }

    //Method: Get
    @GetMapping("/hotels")
    public  List<Hotel> getAllHotels(@RequestParam(required = false) Integer rate,
                                     @RequestParam(required = false) Boolean status)
    {
        return hotelService.findHotelsByRateAndStatus(rate, status);
    }

    //method: get
    //url: /api/v1/hotels/id
    @GetMapping("/hotels/{id}")
    public Hotel getHotel(@PathVariable Long id)
    {
        //return findHotelById(id);
        return hotelService.findHotelById(id);
    }

    //method: put
    //url: /api/v1/hotels/id
    @PutMapping("/hotels/{id}")
    public Hotel updateHotel(@RequestBody UpdateHotelRequest request, @PathVariable Long id)
    {
        return hotelService.updateHotel(id, request);
    }

    //method: delete
    //url: /api/v1/hotels/id
    @DeleteMapping("/hotels/{id}")
    public ResponseDto disableHotel(@PathVariable Long id)
    {

        Hotel hotel = hotelService.disableHotel(id);
        if(hotel==null)
            return new ResponseDto(false, "Hotel not found");

        return new ResponseDto(true,"successful");
    }


    //private get hotel by id
    private Hotel findHotelById(Long id)
    {
        return  hotels.stream().filter(hotel -> hotel.getId().equals(id)).findFirst().orElse(null);
    }
}
