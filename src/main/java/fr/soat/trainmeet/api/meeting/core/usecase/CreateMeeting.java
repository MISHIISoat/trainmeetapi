package fr.soat.trainmeet.api.meeting.core.usecase;

import fr.soat.trainmeet.api.meeting.core.domain.MeetingParams;
import fr.soat.trainmeet.api.meeting.core.domain.MeetingPort;

public class CreateMeeting {
    private final MeetingPort meetingPort;

    public CreateMeeting(MeetingPort meetingPort) {
        this.meetingPort = meetingPort;
    }

    public Long execute(MeetingParams params) {
        return null;
    }
}
