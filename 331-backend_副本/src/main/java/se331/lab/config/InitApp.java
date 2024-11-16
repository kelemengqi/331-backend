package se331.lab.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.repository.EventRepository;
import se331.lab.repository.OrganizerRepository;
import se331.lab.repository.ParticipantRepository;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1, org2, org3;
        org1 = organizerRepository.save(Organizer.builder().name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder().name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder().name("ChiangMai").build());

        Event event1, event2, event3, event4;
        event1 = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
        event1.setOrganizer(org1);
        org1.getOwnEvents().add(event1);

        event2 = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21st Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .build());
        event2.setOrganizer(org1);
        org1.getOwnEvents().add(event2);

        event3 = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21st Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());
        event3.setOrganizer(org2);
        org2.getOwnEvents().add(event3);

        event4 = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .build());
        event4.setOrganizer(org3);
        org3.getOwnEvents().add(event4);

        // 创建参与者并分配到事件
        Participant participant1 = participantRepository.save(Participant.builder()
                .name("Alice")
                .telNo("123456789")
                .eventHistory(Arrays.asList(event1, event2, event3))
                .build());
        Participant participant2 = participantRepository.save(Participant.builder()
                .name("Bob")
                .telNo("987654321")
                .eventHistory(Arrays.asList(event1, event2, event3))
                .build());
        Participant participant3 = participantRepository.save(Participant.builder()
                .name("Charlie")
                .telNo("555555555")
                .eventHistory(Arrays.asList(event1, event2, event3))
                .build());
        Participant participant4 = participantRepository.save(Participant.builder()
                .name("David")
                .telNo("666666666")
                .eventHistory(Arrays.asList(event1))
                .build());
        Participant participant5 = participantRepository.save(Participant.builder()
                .name("Eve")
                .telNo("777777777")
                .eventHistory(Arrays.asList(event2))
                .build());

        // 将参与者添加到事件的参与者列表中（可选，根据需要更新事件的参与者列表）
        event1.getParticipants().addAll(Arrays.asList(participant1, participant2, participant3, participant4));
        event2.getParticipants().addAll(Arrays.asList(participant1, participant2, participant3, participant5));
        event3.getParticipants().addAll(Arrays.asList(participant1, participant2, participant3));
        event4.getParticipants().addAll(Arrays.asList(participant2, participant3, participant5));

        eventRepository.saveAll(Arrays.asList(event1, event2, event3, event4));
    }
}
