package es.ulpgc;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(org.junit.runners.Parameterized.class)
public class BillServicePeriodPoolCheckerAddBill_ {

    private static Object[][] cases;

    static {
        Date d1 = new Date(1, Date.FEBRUARY, 2019);
        Date d2 = new Date(3, Date.MARCH, 2019);

        BillServicePeriod bsp1 = new BillServicePeriod(d1, d2);

        BillServicePeriodPool bspl1 = new BillServicePeriodPool();
        BillServicePeriodPoolChecker bsppc1 = new BillServicePeriodPoolChecker(bspl1);

        cases = new Object[][] {
                {bsppc1, bspl1, bsp1, 1, d1, d2, true}
        };
    }

    private BillServicePeriodPoolChecker billServicePeriodPoolChecker;
    private BillServicePeriodPool billServicePeriodPool;
    private BillServicePeriod billServicePeriod;
    private int billTimeLineSize;
    private Date startDate;
    private Date finishDate;
    private boolean isAdded;

    public BillServicePeriodPoolCheckerAddBill_(BillServicePeriodPoolChecker billServicePeriodPoolChecker,
                                                BillServicePeriodPool billServicePeriodPool, BillServicePeriod billServicePeriod,
                                                int billTimeLineSize, Date startDate, Date finishDate, boolean isAdded) {
        this.billServicePeriodPoolChecker = billServicePeriodPoolChecker;
        this.billServicePeriodPool = billServicePeriodPool;
        this.billTimeLineSize = billTimeLineSize;
        this.billServicePeriod = billServicePeriod;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.isAdded = isAdded;
    }

    @Test
    public void execute(){
        boolean isAdded = billServicePeriodPoolChecker.addBill(billServicePeriod);
        assertThat(isAdded).isEqualTo(this.isAdded);
        assertThat(billServicePeriodPool.getBillTimeLine().size()).isEqualTo(billTimeLineSize);
        assertThat(billServicePeriodPool.getStartDate()).isEqualTo(startDate);
        assertThat(billServicePeriodPool.getFinishDate()).isEqualTo(finishDate);
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return cases;
    }
}