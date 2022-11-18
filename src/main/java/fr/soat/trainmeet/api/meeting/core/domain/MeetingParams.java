package fr.soat.trainmeet.api.meeting.core.domain;

import java.time.LocalDate;

public record MeetingParams(
        String name,
        String description,
        LocalDate firstPotentialDate,
        LocalDate lastPotentialDate,
        String senderEmail,
        String receiverEmail
) {
}
