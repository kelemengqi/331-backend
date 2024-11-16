package se331.lab.rest.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    private String description;
    private String type;

    @OneToMany(mappedBy = "item")
    private List<Bid> bids;

    @OneToOne
    @JoinColumn(name = "successful_bid_id")
    private Bid successfulBid;
}
