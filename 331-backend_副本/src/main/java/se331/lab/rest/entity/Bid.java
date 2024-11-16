package se331.lab.rest.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    private Double amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private AuctionItem item;
}
