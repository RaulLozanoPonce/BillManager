package es.ulpgc;

import java.time.LocalDate;

public class DateSensor {
    public Date now() throws Date.InvalidDate {
        LocalDate localDate = LocalDate.now();
        return new Date(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear());
    }
}
