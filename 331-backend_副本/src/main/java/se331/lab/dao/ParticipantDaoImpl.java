package se331.lab.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.repository.ParticipantRepository;
import se331.lab.rest.entity.Participant;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ParticipantDaoImpl implements ParticipantDao {
    private final ParticipantRepository participantRepository;  // 变量名统一小写

    @Override
    public Page<Participant> getParticipant(Pageable pageRequest) {
        // 使用 pageable 分页查询参与者
        return participantRepository.findAll(pageRequest);
    }

    @Override
    public Optional<Participant> findById(Long id) {
        // 查询单个参与者
        return participantRepository.findById(id);
    }
}
