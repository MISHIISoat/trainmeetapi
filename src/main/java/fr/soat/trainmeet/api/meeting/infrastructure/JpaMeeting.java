package fr.soat.trainmeet.api.meeting.infrastructure;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "meeting")
public class JpaMeeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate firstPotentialDate;
    private LocalDate lastPotentialDate;
    private boolean isConfirmed;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private JpaAccount sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private JpaAccount receiver;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getFirstPotentialDate() {
        return firstPotentialDate;
    }

    public LocalDate getLastPotentialDate() {
        return lastPotentialDate;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public JpaAccount getSender() {
        return sender;
    }

    public JpaAccount getReceiver() {
        return receiver;
    }

    public static final class JpaMeetingBuilder {
        private Long id;
        private String name;
        private String description;
        private LocalDate firstPotentialDate;
        private LocalDate lastPotentialDate;
        private boolean isConfirmed;
        private JpaAccount sender;
        private JpaAccount receiver;

        private JpaMeetingBuilder() {
        }

        public static JpaMeetingBuilder builder() {
            return new JpaMeetingBuilder();
        }

        public JpaMeetingBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public JpaMeetingBuilder name(String name) {
            this.name = name;
            return this;
        }

        public JpaMeetingBuilder description(String description) {
            this.description = description;
            return this;
        }

        public JpaMeetingBuilder firstPotentialDate(LocalDate firstPotentialDate) {
            this.firstPotentialDate = firstPotentialDate;
            return this;
        }

        public JpaMeetingBuilder lastPotentialDate(LocalDate lastPotentialDate) {
            this.lastPotentialDate = lastPotentialDate;
            return this;
        }

        public JpaMeetingBuilder isConfirmed(boolean isConfirmed) {
            this.isConfirmed = isConfirmed;
            return this;
        }

        public JpaMeetingBuilder sender(JpaAccount sender) {
            this.sender = sender;
            return this;
        }

        public JpaMeetingBuilder receiver(JpaAccount receiver) {
            this.receiver = receiver;
            return this;
        }

        public JpaMeeting build() {
            JpaMeeting jpaMeeting = new JpaMeeting();
            jpaMeeting.name = this.name;
            jpaMeeting.lastPotentialDate = this.lastPotentialDate;
            jpaMeeting.firstPotentialDate = this.firstPotentialDate;
            jpaMeeting.id = this.id;
            jpaMeeting.receiver = this.receiver;
            jpaMeeting.isConfirmed = this.isConfirmed;
            jpaMeeting.description = this.description;
            jpaMeeting.sender = this.sender;
            return jpaMeeting;
        }
    }
}
