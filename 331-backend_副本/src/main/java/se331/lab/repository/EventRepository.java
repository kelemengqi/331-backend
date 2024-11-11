package se331.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // 此处可以添加自定义查询方法
}
