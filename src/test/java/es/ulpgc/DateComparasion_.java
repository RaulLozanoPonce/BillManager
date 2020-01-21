package es.ulpgc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(org.junit.runners.Parameterized.class)
public class DateComparasion_ {

    private static Object[][] cases;

    static {
        Date d1 = new Date(1, Date.MARCH, 2019);
        Date d2 = new Date(3, Date.MARCH, 2019);
        Date d3 = new Date(1, Date.FEBRUARY, 2019);
        Date d4 = new Date(1, Date.MARCH, 2020);
        Date d5 = new Date(7, Date.AUGUST, 2004);

        cases = new Object[][] {
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
                {d5, d1, -1, -2}
        };
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
