package es.ulpgc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(org.junit.runners.Parameterized.class)
public class BillServicePeriodPoolConstructor_ {

    private static Object[][] cases;

    static {
        BillServicePeriodPool bspp1 = new BillServicePeriodPool();

        cases = new Object[][] {
                {bspp1, 0, null, null, null, NoSuchElementException.class}
        };
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
            assertTrue(exceptionClass == null);
        } catch(NoSuchElementException e) {
            assertThat(billServicePeriodPool.getBillTimeLine().size()).isEqualTo(billTimeLineSize);
            assertThat(billServicePeriodPool.getStartDate()).isEqualTo(startDate);
            assertThat(billServicePeriodPool.getFinishDate()).isEqualTo(finishDate);
            assertFalse(exceptionClass == null);
        }
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return cases;
    }
}
