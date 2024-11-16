package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Event;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")  // 使用手动配置的存储实现
public class EventDaoDbImpl implements EventDao {

    private List<Event> eventList;

    @PostConstruct
    public void init() {
        eventList = new ArrayList<>();
        eventList.add(Event.builder()
                .id(123L)
                .category("animal welfare")
                .title("Cat Adoption Day")
                .description("Find your new feline friend at this event.")
                .location("Meow Town")
                .date("January 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .build());
        eventList.add(Event.builder()
                .id(456L)
                .category("food")
                .title("Community Gardening")
                .description("Join us as we tend to the community edible plants.")
                .location("Flora City")
                .date("March 14, 2022")
                .time("10:00")
                .petAllowed(true)

                .build());
        eventList.add(Event.builder()
                .id(789L)
                .category("sustainability")
                .title("Beach Cleanup")
                .description("Help pick up trash along the shore.")
                .location("Playa Del Carmen")
                .date("July 22, 2022")
                .time("11:00")
                .petAllowed(false)
                                .build());
        eventList.add(Event.builder()
                .id(1001L)
                .category("animal welfare")
                .title("Dog Adoption Day")
                .description("Find your new canine friend at this event.")
                .location("Woof Town")
                .date("August 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .build());
        eventList.add(Event.builder()
                .id(1002L)
                .category("food")
                .title("Canned Food Drive")
                .description("Bring your canned food to donate to those in need.")
                .location("Tin City")
                .date("September 14, 2022")
                .time("3:00")
                .petAllowed(true)

                .build());
        eventList.add(Event.builder()
                .id(1003L)
                .category("sustainability")
                .title("Highway Cleanup")
                .description("Help pick up trash along the highway.")
                .location("Highway 50")
                .date("July 22, 2022")
                .time("11:00")
                .petAllowed(false)

                .build());
        // 继续添加更多事件...
    }

    @Override
    public Integer getEventSize() {
        return eventList.size();
    }

    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page) {
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, eventList.size());
        List<Event> subList = eventList.subList(start, end);
        return new PageImpl<>(subList, PageRequest.of(page - 1, pageSize), eventList.size());
    }

    @Override
    public Event save(Event event) {
        // 手动分配 ID 给事件
        long newId = eventList.size() + 1;  // 创建新的 ID（这里假设简单地递增）
        event.setId(newId);  // 设置 ID
        eventList.add(event);  // 将事件添加到事件列表
        return event;  // 返回保存的事件
    }

    @Override
    public Event getEvent(Long id) {
        for (Event event : eventList) {
            if (event.getId().equals(id)) {
                return event;  // 找到事件并返回
            }
        }
        return null;  // 没有找到对应的事件，返回 null
    }
}
