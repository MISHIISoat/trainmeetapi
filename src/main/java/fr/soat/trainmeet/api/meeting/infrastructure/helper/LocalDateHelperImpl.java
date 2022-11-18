package fr.soat.trainmeet.api.meeting.infrastructure.helper;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LocalDateHelperImpl implements LocalDateHelper{
    @Override
    public LocalDate today() {
        return LocalDate.now();
    }
}
