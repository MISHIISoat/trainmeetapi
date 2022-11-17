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

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private JpaAccount sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private JpaAccount receiver;
}
