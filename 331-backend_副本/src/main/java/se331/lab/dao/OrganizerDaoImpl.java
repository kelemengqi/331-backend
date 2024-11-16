package se331.lab.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.repository.OrganizerRepository;
import se331.lab.rest.entity.Organizer;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrganizerDaoImpl implements OrganizerDao {
    final OrganizerRepository organizerRepository;

    @Override
    public Page<Organizer> getOrganizer(Pageable pageRequest) {
        return organizerRepository.findAll(pageRequest);
    }

    @Override
    public Optional<Organizer> findById(Long id) {
        return organizerRepository.findById(id); // 查询单个组织者
    }
}
