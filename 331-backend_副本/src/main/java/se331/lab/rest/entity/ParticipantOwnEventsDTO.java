package se331.lab.rest.entity;

import java.util.List;
import lombok.Data;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantOwnEventsDTO {
    Long id;
    String category;
    String title;
    String description;
    String location;
    String date;
    String time;
    Boolean petAllowed;
    List<Participant> participants;
}
