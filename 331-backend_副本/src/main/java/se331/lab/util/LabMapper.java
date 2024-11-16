package se331.lab.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab.rest.entity.*;

import java.util.List;

@Mapper
public interface LabMapper {
 LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
 EventDTO getEventDto(Event event);
 List<EventDTO> getEventDto(List<Event> events);

 OrganizerDTO getOrganizerDTO(Organizer organizer);
 List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers);

 // Participant 的转换方法
 ParticipantDTO getParticipantDTO(Participant participant);
 List<ParticipantDTO> getParticipantDTO(List<Participant> participants);

 ParticipantOwnEventsDTO getParticipantOwnEventsDTO(Event event);
 List<ParticipantOwnEventsDTO> getParticipantOwnEventsDTO(List<Event> event);
}