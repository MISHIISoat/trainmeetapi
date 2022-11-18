package fr.soat.trainmeet.api.meeting.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAccountRepository extends JpaRepository<JpaAccount, Long> {
    JpaAccount findByEmail(String email);
}
