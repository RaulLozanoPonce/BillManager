package es.ulpgc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import es.ulpgc.BillServicePeriod.InvalidBillServicePeriod;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(org.junit.runners.Parameterized.class)
public class BillServicePeriodConstructor_ {

    private static Object[][] cases;

    static {
        try {
            Date d1 = new Date(1, Date.FEBRUARY, 2019);
            Date d2 = new Date(3, Date.MARCH, 2019);
            Date d3 = new Date(1, Date.FEBRUARY, 2019);

            cases = new Object[][]{
                    {d1, d2, null},
                    {d2, d1, InvalidBillServicePeriod.class},
                    {d1, d3, InvalidBillServicePeriod.class},
                    {null, d1, InvalidBillServicePeriod.class},
                    {d1, null, InvalidBillServicePeriod.class},
                    {null, null, InvalidBillServicePeriod.class}
            };
        } catch(Exception ignored) {}
    }

    private Date startDate;
    private Date finishDate;
    private Object exceptionClass;

    public BillServicePeriodConstructor_(Date startDate, Date finishDate, Object exceptionClass) {
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.exceptionClass = exceptionClass;
    }

    @Test
    public void execute(){
        try {
            BillServicePeriod bsp = new BillServicePeriod(startDate, finishDate);
            assertThat(bsp.getStartDate().compareTo(startDate)).isEqualTo(0);
            assertThat(bsp.getFinishDate().compareTo(finishDate)).isEqualTo(0);
            assertTrue(exceptionClass == null);
        } catch(InvalidBillServicePeriod e) {
            assertFalse(exceptionClass == null);
        }
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return cases;
    }

}
