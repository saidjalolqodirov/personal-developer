package uz.qodirov.springprofiles;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
@Profile("prod")
public class ScheduledTask {

    @Scheduled(fixedRate = 1000)
    public void profileTest() {
        System.out.println(new Date());
    }

    public static void main(String[] args) {
        DateTimeFormatter localDateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime localDateTime = parseToLocalDate("12.01.2023 12:00", localDateFormat);
        System.out.println(localDateTime);
    }

    public static LocalDateTime parseToLocalDate(String dateAsString, DateTimeFormatter dateFormat) {
        try {
            return LocalDateTime.parse(dateAsString, dateFormat);
        } catch (Exception ignored) {

        }
        return null;
    }
}
