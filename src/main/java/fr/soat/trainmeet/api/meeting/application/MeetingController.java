package fr.soat.trainmeet.api.meeting.application;

import fr.soat.trainmeet.api.meeting.core.domain.MeetingParams;
import fr.soat.trainmeet.api.meeting.core.usecase.CreateMeeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/meeting")
public class MeetingController {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final CreateMeeting createMeeting;

    public MeetingController(CreateMeeting createMeeting) {
        this.createMeeting = createMeeting;
    }

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody MeetingJson meetingJson) {
        MeetingParams meetingParams = toMeetingParams(meetingJson);
        Long id = createMeeting.execute(meetingParams);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    private MeetingParams toMeetingParams(MeetingJson meetingJson) {
        return new MeetingParams(
                meetingJson.name(),
                meetingJson.description(),
                LocalDate.parse(meetingJson.firstPotentialDate(), DATE_TIME_FORMATTER),
                LocalDate.parse(meetingJson.lastPotentialDate(), DATE_TIME_FORMATTER),
                meetingJson.senderEmail(),
                meetingJson.receiverEmail()
        );
    }
}
