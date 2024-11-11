package se331.lab.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Event {
 @jakarta.persistence.Id
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
 String organizer;
}