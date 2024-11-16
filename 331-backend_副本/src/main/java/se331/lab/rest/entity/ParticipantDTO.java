package se331.lab.rest.entity;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantDTO {

    Long id;
    String name;
    String telNo;
    List<ParticipantOwnEventsDTO> eventHistory = new ArrayList<>();
}

