package es.ulpgc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(org.junit.runners.Parameterized.class)
public class DateComparasion_ {

    private static Object[][] cases;

    static {
        try {
            Date d1 = new Date(1, Date.MARCH, 2019);
            Date d2 = new Date(3, Date.MARCH, 2019);
            Date d3 = new Date(1, Date.FEBRUARY, 2019);
            Date d4 = new Date(1, Date.MARCH, 2020);
            Date d5 = new Date(7, Date.AUGUST, 2004);
            Date d6 = new Date(4, Date.MARCH, 2019);
            Date d7 = new Date(31, Date.JANUARY, 2019);
            Date d8 = new Date(28, Date.FEBRUARY, 2019);
            Date d9 = new Date(29, Date.FEBRUARY, 2020);
            Date d10 = new Date(30, Date.APRIL, 2019);
            Date d11 = new Date(1, Date.MAY, 2019);
            Date d12 = new Date(31, Date.DECEMBER, 2019);
            Date d13 = new Date(1, Date.JANUARY, 2020);

            cases = new Object[][]{
                    {d1, d1, 0, 0},
                    {d1, d2, -1, -2},
                    {d2, d1, 1, 2},
                    {d1, d3, 1, 2},
                    {d3, d1, -1, -2},
                    {d1, d4, -1, -2},
                    {d4, d1, 1, 2},
                    {d2, d3, 1, 2},
                    {d3, d2, -1, -2},
                    {d2, d4, -1, -2},
                    {d4, d2, 1, 2},
                    {d3, d4, -1, -2},
                    {d4, d3, 1, 2},
                    {d1, d5, 1, 2},
                    {d5, d1, -1, -2},
                    {d2, d6, -1, -1},
                    {d6, d2, 1, 1},
                    {d7, d3, -1, -1},
                    {d3, d7, 1, 1},
                    {d10, d11, -1, -1},
                    {d11, d10, 1, 1},
                    {d8, d1, -1, -1},
                    {d1, d8, 1, 1},
                    {d9, d4, -1, -1},
                    {d4, d9, 1, 1},
                    {d12, d13, -1, -1},
                    {d13, d12, 1, 1}
            };
        } catch(Exception ignored) {}
    }

    private Date date1;
    private Date date2;
    private int compare;
    private int adjacent;

    public DateComparasion_(Date date1, Date date2, int compare, int adjacent) {
        this.date1 = date1;
        this.date2 = date2;
        this.compare = compare;
        this.adjacent = adjacent;
    }

    @Test
    public void execute(){
        assertThat(date1.compareTo(date2)).isEqualTo(compare);
        assertThat(date1.adjacentDays(date2)).isEqualTo(adjacent);
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return cases;
    }
}
