package booking.repository;

import booking.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findAll();

    Hotel findHotelById(Long id);

    @Query("SELECT h FROM Hotel h WHERE (:rate IS NULL OR h.rate = :rate) AND (:status IS NULL OR h.status = :status)")
    List<Hotel> findHotelsByRateAndStatus(@Param("rate") Integer rate, @Param("status") Boolean status);
}
