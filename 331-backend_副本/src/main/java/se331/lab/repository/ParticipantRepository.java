package se331.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Participant;
@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
