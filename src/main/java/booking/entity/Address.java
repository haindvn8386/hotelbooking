package booking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "street",  length = 500)
    private String street   ;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "province", length = 100)
    private String province;

    @Column(name = "nation", length = 100)
    private String nation;

    private Integer version;
}
