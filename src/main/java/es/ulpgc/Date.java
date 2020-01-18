package es.ulpgc;

import java.time.LocalDate;
import java.util.Objects;

public class Date implements Comparable<Date> {

    public static int JANUARY = 0;
    public static int FEBRUARY = 1;
    public static int MARCH = 2;
    public static int APRIL = 3;
    public static int MAY = 4;
    public static int JUNE = 5;
    public static int JULY = 6;
    public static int AUGUST = 7;
    public static int SEPTEMBER = 8;
    public static int OCTOBER = 9;
    public static int NOVEMBER = 10;
    public static int DECEMBER = 11;

    private final Integer day;
    private final Integer month;
    private final Integer year;

    public Date() {
        this.day = null;
        this.month = null;
        this.year = null;
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Integer getDay() {
        return day;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    public Date now() {
        LocalDate localDate = LocalDate.now();
        return new Date(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear());
    }

    @Override
    public int compareTo(Date date) {
        if(Objects.requireNonNull(year) < date.getYear()) return -1;
        if(Objects.requireNonNull(year) > date.getYear()) return 1;
        if(Objects.requireNonNull(month) < date.getMonth()) return -1;
        if(Objects.requireNonNull(month) > date.getMonth()) return 1;
        return Objects.requireNonNull(day).compareTo(date.getDay());
    }
}
