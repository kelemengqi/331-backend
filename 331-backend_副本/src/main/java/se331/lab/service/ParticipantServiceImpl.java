package se331.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.dao.ParticipantDao;

import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantDao participantDao;  // 成员变量统一小写

    // 获取所有参与者，返回 List 类型
    @Override
    public List<Participant> getAllParticipant() {
        return participantDao.getParticipant(Pageable.unpaged()).getContent();  // 使用 unpaged 获取所有参与者
    }

    // 获取所有参与者并返回一个单独的 Organizer 类型 (此方法根据需求进行修改)


    // 获取分页的参与者列表
    @Override
    public Page<Participant> getParticipant(Integer page, Integer pageSize) {
        return participantDao.getParticipant(PageRequest.of(page, pageSize));
    }
}
