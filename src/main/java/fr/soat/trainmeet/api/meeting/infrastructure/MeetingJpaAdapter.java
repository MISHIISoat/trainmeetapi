package fr.soat.trainmeet.api.meeting.infrastructure;

import fr.soat.trainmeet.api.meeting.core.domain.Meeting;
import fr.soat.trainmeet.api.meeting.core.domain.MeetingPort;
import org.springframework.stereotype.Repository;

@Repository
public class MeetingJpaAdapter implements MeetingPort {
    @Override
    public Long save(Meeting meeting) {
        return null;
    }
}
