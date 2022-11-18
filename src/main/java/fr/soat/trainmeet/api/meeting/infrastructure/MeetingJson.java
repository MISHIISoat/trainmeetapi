package fr.soat.trainmeet.api.meeting.infrastructure;

public record MeetingJson(
        String name,
        String description,
        String firstPotentialDate,
        String lastPotentialDate,
        String senderEmail,
        String receiverEmail
) {
}
