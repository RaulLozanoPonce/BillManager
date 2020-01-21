package es.ulpgc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import es.ulpgc.Date.InvalidDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(org.junit.runners.Parameterized.class)
public class DateConstructor_ {

    private static Object[][] cases;

    static {
        cases = new Object[][] {
                {0, 1, 1, InvalidDate.class},
                {1, 0, 1, InvalidDate.class},
                {1, 1, 0, InvalidDate.class},
                {0, 0, 1, InvalidDate.class},
                {0, 1, 0, InvalidDate.class},
                {1, 0, 0, InvalidDate.class},
                {0, 0, 0, InvalidDate.class},
                {-1, 1, 1, InvalidDate.class},
                {1, -1, 1, InvalidDate.class},
                {1, 1, -1, InvalidDate.class},
                {-1, -1, 1, InvalidDate.class},
                {-1, 1, -1, InvalidDate.class},
                {1, -1, -1, InvalidDate.class},
                {-1, -1, -1, InvalidDate.class}
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
            assertTrue(exceptionClass == null);
        } catch(InvalidDate e) {
            assertFalse(exceptionClass == null);
        }
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return cases;
    }
}
