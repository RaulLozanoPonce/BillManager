package es.ulpgc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(org.junit.runners.Parameterized.class)
public class BillServicePeriodConstructor_ {

    private static Object[][] cases;

    static {
        Date d1 = new Date(1, Date.FEBRUARY, 2019);
        Date d2 = new Date(3, Date.MARCH, 2019);

        BillServicePeriod bsp1 = new BillServicePeriod(d1, d2);

        cases = new Object[][] {
                {bsp1, d1, d2, null}
        };
    }

    private BillServicePeriod billServicePeriod;
    private Date startDate;
    private Date finishDate;
    private Object exceptionClass;

    public BillServicePeriodConstructor_(BillServicePeriod billServicePeriod, Date startDate, Date finishDate,
                                         Object exceptionClass) {
        this.billServicePeriod = billServicePeriod;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.exceptionClass = exceptionClass;
    }

    @Test
    public void execute(){
        assertThat(billServicePeriod.getStartDate().compareTo(startDate)).isEqualTo(0);
        assertThat(billServicePeriod.getFinishDate().compareTo(finishDate)).isEqualTo(0);
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return cases;
    }

}
