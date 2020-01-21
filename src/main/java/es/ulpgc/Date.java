package es.ulpgc;

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

    private static int[] DAYOFMONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private final int day;
    private final int month;
    private final int year;

    public Date(int day, int month, int year) throws InvalidDate {
        verifyDate(day, month, year);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    private void verifyDate(int day, int month, int year) throws InvalidDate {
        if(day <= 0 || month < 0 || year <= 0) throw new InvalidDate();
        if(day > DAYOFMONTH[month]) throw new InvalidDate();
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

    @Override
    public int compareTo(Date date) {
        int thisYearToCompare = year;
        int otherYearToCompare = date.getYear();
        int thisMonthToCompare = month;
        int otherMonthToCompare = date.getMonth();
        int thisDayToCompare = day;
        int otherDayToCompare = date.getDay();

        if(thisYearToCompare < otherYearToCompare) {
            return -1;
        } else if(thisYearToCompare > otherYearToCompare) {
            return 1;
        } else {
            if(thisMonthToCompare < otherMonthToCompare) {
                return -1;
            } else if(thisMonthToCompare > otherMonthToCompare) {
                return 1;
            } else {
                return Integer.compare(thisDayToCompare, otherDayToCompare);
            }
        }
    }

    public int adjacentDays(Date date) {
        int thisYearToCompare = year;
        int otherYearToCompare = date.getYear();
        int thisMonthToCompare = month;
        int otherMonthToCompare = date.getMonth();
        int thisDayToCompare = day;
        int otherDayToCompare = date.getDay();

        int yearDifference = thisYearToCompare - otherYearToCompare;
        if(Math.abs(yearDifference) > 1) {
            return 2*obtainSign(yearDifference);
        } else if(Math.abs(thisYearToCompare - otherYearToCompare) == 1) {
            if(this.compareTo(date) < 0) {
                if(thisDayToCompare == DAYOFMONTH[DECEMBER] && thisMonthToCompare == DECEMBER && otherDayToCompare == 1 && otherMonthToCompare == JANUARY) {
                    return -1;
                } else {
                    return -2;
                }
            } else {
                if(otherDayToCompare == DAYOFMONTH[DECEMBER] && otherMonthToCompare == DECEMBER && thisDayToCompare == 1 && thisMonthToCompare == JANUARY) {
                    return 1;
                } else {
                    return 2;
                }
            }
        } else {
            int monthDifference = thisMonthToCompare - otherMonthToCompare;
            if(Math.abs(monthDifference) > 1) {
                return 2*obtainSign(monthDifference);
            } else if(Math.abs(thisMonthToCompare - otherMonthToCompare) == 1) {
                if(this.compareTo(date) < 0) {
                    if(thisDayToCompare == DAYOFMONTH[thisMonthToCompare] && otherDayToCompare == 1) {
                        return -1;
                    } else {
                        return -2;
                    }
                } else {
                    if(otherDayToCompare == DAYOFMONTH[otherMonthToCompare] && thisDayToCompare == 1) {
                        return 1;
                    } else {
                        return 2;
                    }
                }
            } else {
                int dayDifference = thisDayToCompare - otherDayToCompare;
                if(dayDifference == -1 || dayDifference == 0 || dayDifference == 1) {
                    return dayDifference;
                }
                return 2*obtainSign(dayDifference);
            }
        }
    }

    private int obtainSign(int number) {
        if(number < 0) {
            return -1;
        } else {
            return 1;
        }
    }

    public class InvalidDate extends Exception {

    }
}
