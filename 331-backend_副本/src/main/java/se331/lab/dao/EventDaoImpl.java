package se331.lab.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.repository.EventRepository;
import se331.lab.rest.entity.Event;

@Profile("db")
@Repository
@RequiredArgsConstructor
public class EventDaoImpl implements EventDao {

    // 自动注入 EventRepository
    final EventRepository eventRepository;

    // 获取事件总数
    @Override
    public Integer getEventSize() {
        return Math.toIntExact(eventRepository.count());
    }

    // 获取分页的事件列表
    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? 10 : pageSize;  // 默认每页显示10条
        page = page == null ? 1 : page;  // 默认第一页
        return eventRepository.findAll(PageRequest.of(page - 1, pageSize));  // 使用 Spring Data JPA 的分页方法
    }

    // 获取单个事件
    @Override
    public Event getEvent(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    // 保存事件
    @Override
    public Event save(Event event) {
        return eventRepository.save(event);  // 直接通过 repository 保存事件
    }
}
