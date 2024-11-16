
        package se331.lab.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Event {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @EqualsAndHashCode.Exclude
 Long id;
 String category;
 String title;
 String description;
 String location;
 String date;
 String time;
 Boolean petAllowed;
 @ManyToOne
 @JoinColumn(name="organizer_id")
 Organizer organizer;
 @ManyToMany(mappedBy = "eventHistory")
 @Builder.Default
 @JsonIgnore
 List<Participant> participants = new ArrayList<>();

 }

