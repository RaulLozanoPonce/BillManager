package es.ulpgc;

public class Date {

    public int JANUARY = 0;
    public int FEBRUARY = 1;
    public int MARCH = 2;
    public int APRIL = 3;
    public int MAY = 4;
    public int JUNE = 5;
    public int JULY = 6;
    public int AUGUST = 7;
    public int SEPTEMBER = 8;
    public int OCTOBER = 9;
    public int NOVEMBER = 10;
    public int DECEMBER = 11;

    private final int day;
    private final int month;
    private final int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
