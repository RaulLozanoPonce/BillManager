package es.ulpgc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import es.ulpgc.Date.InvalidDate;

import static org.junit.Assert.*;

@RunWith(org.junit.runners.Parameterized.class)
public class DateConstructor_ {

    private static Object[][] cases;

    static {
        cases = new Object[][] {
                {0, 1, 1, InvalidDate.class},
                {1, 1, 0, InvalidDate.class},
                {0, 1, 0, InvalidDate.class},
                {-1, 1, 1, InvalidDate.class},
                {1, -1, 1, InvalidDate.class},
                {1, 1, -1, InvalidDate.class},
                {-1, -1, 1, InvalidDate.class},
                {-1, 1, -1, InvalidDate.class},
                {1, -1, -1, InvalidDate.class},
                {-1, -1, -1, InvalidDate.class},
                {32, Date.JANUARY, 2019, InvalidDate.class},
                {31, Date.APRIL, 2019, InvalidDate.class},
                {31, Date.JANUARY, 2019, null},
                {30, Date.APRIL, 2019, null},
                {30, 12, 2019, InvalidDate.class},
                {28, Date.FEBRUARY, 2019, null},
                {28, Date.FEBRUARY, 2020, null},
                {29, Date.FEBRUARY, 2019, InvalidDate.class},
                {29, Date.FEBRUARY, 2020, null},
                {29, Date.FEBRUARY, 2000, null},
                {29, Date.FEBRUARY, 1900, InvalidDate.class},
        };
    }

    private int day;
    private int month;
    private int year;
    private Object exceptionClass;

    public DateConstructor_(int day, int month, int year, Object exceptionClass) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.exceptionClass = exceptionClass;
    }

    @Test
    public void execute(){
        try {
            new Date(day, month, year);
            assertNull(exceptionClass);
        } catch(InvalidDate e) {
            assertNotNull(exceptionClass);
        }
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return cases;
    }
}
