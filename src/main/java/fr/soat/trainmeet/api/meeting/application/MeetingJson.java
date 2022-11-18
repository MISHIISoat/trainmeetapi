package fr.soat.trainmeet.api.meeting.application;

public record MeetingJson(
        String name,
        String description,
        String firstPotentialDate,
        String lastPotentialDate,
        String senderEmail,
        String receiverEmail
) {
}
