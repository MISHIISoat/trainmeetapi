package fr.soat.trainmeet.api.meeting.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMeetingRepository extends JpaRepository<JpaMeeting, Long> {
}
