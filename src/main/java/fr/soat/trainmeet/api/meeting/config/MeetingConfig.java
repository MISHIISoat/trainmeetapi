package fr.soat.trainmeet.api.meeting.config;

import fr.soat.trainmeet.api.meeting.core.domain.MeetingPort;
import fr.soat.trainmeet.api.meeting.core.usecase.CreateMeeting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MeetingConfig {
    @Bean
    public CreateMeeting createMeeting(MeetingPort meetingPort) {
        return new CreateMeeting(meetingPort);
    }
}
