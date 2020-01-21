package es.ulpgc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(org.junit.runners.Parameterized.class)
public class BillServicePeriodPoolConstructor_ {

    private static Object[][] cases;

    static {
        try {
            Date d1 = new Date(1, Date.FEBRUARY, 2019);
            Date d2 = new Date(3, Date.MARCH, 2019);
            Date d3 = new Date(2, Date.APRIL, 2019);

            BillServicePeriod bsp1 = new BillServicePeriod(d1, d2);
            BillServicePeriodPool bspp1 = new BillServicePeriodPool();
            BillServicePeriodPool bspp2 = new BillServicePeriodPool(bsp1);
            BillServicePeriodPool bspp3 = new BillServicePeriodPool(d2, d3);
            BillServicePeriodPool bspp4 = new BillServicePeriodPool(bsp1, d1, d3);

            cases = new Object[][] {
                    {bspp1, 0, null, null, null, NoSuchElementException.class},
                    {bspp2, 1, bsp1, d1, d2, null},
                    {bspp3, 0, null, d2, d3, NoSuchElementException.class},
                    {bspp4, 1, bsp1, d1, d3, null}
            };
        } catch(Exception ignored) {}
    }

    private BillServicePeriodPool billServicePeriodPool;
    private int billTimeLineSize;
    private BillServicePeriod billServicePeriod;
    private Date startDate;
    private Date finishDate;
    private Object exceptionClass;

    public BillServicePeriodPoolConstructor_(BillServicePeriodPool billServicePeriodPool, int billTimeLineSize, BillServicePeriod billServicePeriod, Date startDate, Date finishDate, Object exceptionClass) {
        this.billServicePeriodPool = billServicePeriodPool;
        this.billTimeLineSize = billTimeLineSize;
        this.billServicePeriod = billServicePeriod;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.exceptionClass = exceptionClass;
    }

    @Test
    public void execute(){
        try {
            assertThat(billServicePeriodPool.getBillTimeLine().size()).isEqualTo(billTimeLineSize);
            assertThat(billServicePeriodPool.getBillTimeLine().iterator().next()).isEqualTo(billServicePeriod);
            assertThat(billServicePeriodPool.getStartDate()).isEqualTo(startDate);
            assertThat(billServicePeriodPool.getFinishDate()).isEqualTo(finishDate);
            assertNull(exceptionClass);
        } catch(NoSuchElementException e) {
            assertThat(billServicePeriodPool.getBillTimeLine().size()).isEqualTo(billTimeLineSize);
            assertThat(billServicePeriodPool.getStartDate()).isEqualTo(startDate);
            assertThat(billServicePeriodPool.getFinishDate()).isEqualTo(finishDate);
            assertNotNull(exceptionClass);
        }
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return cases;
    }
}
