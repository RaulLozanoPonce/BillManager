package es.ulpgc;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(org.junit.runners.Parameterized.class)
public class BillServicePeriodPoolCheckerAddBill_ {

    private static Object[][] cases;

    static {
        Date dateNow = new Date().now();

        Date d1 = new Date(1, Date.FEBRUARY, 2019);
        Date d2 = new Date(3, Date.MARCH, 2019);
        Date d3 = new Date(4, Date.MARCH, 2019);
        Date d4 = new Date(6, Date.APRIL, 2019);

        BillServicePeriod bsp1 = new BillServicePeriod(d1, d2);
        BillServicePeriod bsp2 = new BillServicePeriod(d3, d4);

        BillServicePeriodPool bspp1 = new BillServicePeriodPool();
        BillServicePeriodPool bspp2 = new BillServicePeriodPool(bsp1);
        BillServicePeriodPool bspp3 = new BillServicePeriodPool(d2, d3);
        BillServicePeriodPool bspp4 = new BillServicePeriodPool(bsp1, d1, d3);

        BillServicePeriodPoolChecker bsppc1 = new BillServicePeriodPoolChecker(bspp1);
        BillServicePeriodPoolChecker bsppc2 = new BillServicePeriodPoolChecker(bspp2);
        BillServicePeriodPoolChecker bsppc3 = new BillServicePeriodPoolChecker(bspp3);
        BillServicePeriodPoolChecker bsppc4 = new BillServicePeriodPoolChecker(bspp4);

        cases = new Object[][] {
                {bsppc1, bspp1, bsp1, 1, d1, dateNow, true},
                {bsppc2, bspp2, bsp2, 2, d1, dateNow, true},
                {bsppc3, bspp3, bsp2, 1, d2, dateNow, true},
                {bsppc4, bspp4, bsp2, 2, d1, dateNow, true}
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

        assertThat(billServicePeriodPool.getFinishDate().getDay()).isEqualTo(finishDate.getDay());
        assertThat(billServicePeriodPool.getFinishDate().getMonth()).isEqualTo(finishDate.getMonth());
        assertThat(billServicePeriodPool.getFinishDate().getYear()).isEqualTo(finishDate.getYear());
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return cases;
    }
}