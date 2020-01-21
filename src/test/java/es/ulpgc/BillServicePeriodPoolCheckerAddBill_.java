package es.ulpgc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(org.junit.runners.Parameterized.class)
public class BillServicePeriodPoolCheckerAddBill_ {

    private static Object[][] cases;

    static {
        try {
            Date dateNow = new Date(18, Date.APRIL, 2019);
            Date dateNow2 = new Date(3, Date.JUNE, 2019);

            Date d1 = new Date(1, Date.FEBRUARY, 2019);
            Date d2 = new Date(3, Date.MARCH, 2019);
            Date d3 = new Date(4, Date.MARCH, 2019);
            Date d4 = new Date(6, Date.APRIL, 2019);
            Date d5 = new Date(7, Date.APRIL, 2019);
            Date d6 = new Date(4, Date.MAY, 2019);
            Date d7 = new Date(5, Date.MAY, 2019);
            Date d8 = new Date(2, Date.JUNE, 2019);
            Date d9 = new Date(2, Date.MARCH, 2019);
            Date d10 = new Date(8, Date.MAY, 2019);
            Date d11 = new Date(18, Date.MARCH, 2019);
            Date d12 = new Date(18, Date.APRIL, 2019);

            BillServicePeriod bsp1 = new BillServicePeriod(d1, d2);
            BillServicePeriod bsp2 = new BillServicePeriod(d3, d4);
            BillServicePeriod bsp3 = new BillServicePeriod(d5, d6);
            BillServicePeriod bsp4 = new BillServicePeriod(d7, d8);
            BillServicePeriod bsp5 = new BillServicePeriod(d1, d9);
            BillServicePeriod bsp6 = new BillServicePeriod(d10, d8);
            BillServicePeriod bsp7 = new BillServicePeriod(d1, d3);
            BillServicePeriod bsp8 = new BillServicePeriod(d6, d8);
            BillServicePeriod bsp9 = new BillServicePeriod(d11, d12);

            BillServicePeriodPool bspp1 = new BillServicePeriodPool();
            BillServicePeriodPool bspp2 = new BillServicePeriodPool(bsp1);
            BillServicePeriodPool bspp3 = new BillServicePeriodPool(d2, d3);
            BillServicePeriodPool bspp4 = new BillServicePeriodPool(bsp1, d1, d3);
            BillServicePeriodPool bspp5 = new BillServicePeriodPool();
            BillServicePeriodPool bspp6 = new BillServicePeriodPool(bsp1);
            BillServicePeriodPool bspp7 = new BillServicePeriodPool(d2, d3);
            BillServicePeriodPool bspp8 = new BillServicePeriodPool(bsp1, d1, d3);
            BillServicePeriodPool bspp9 = new BillServicePeriodPool(d1, d8);
            BillServicePeriodPool bspp10 = new BillServicePeriodPool(d1, d8);
            BillServicePeriodPool bspp11 = new BillServicePeriodPool(d1, d8);
            BillServicePeriodPool bspp12 = new BillServicePeriodPool(d1, d8);

            BillServicePeriodPoolChecker bsppc1 = new BillServicePeriodPoolChecker(bspp1);
            BillServicePeriodPoolChecker bsppc2 = new BillServicePeriodPoolChecker(bspp2);
            BillServicePeriodPoolChecker bsppc3 = new BillServicePeriodPoolChecker(bspp3);
            BillServicePeriodPoolChecker bsppc4 = new BillServicePeriodPoolChecker(bspp4);
            BillServicePeriodPoolChecker bsppc5 = new BillServicePeriodPoolChecker(bspp5);
            BillServicePeriodPoolChecker bsppc6 = new BillServicePeriodPoolChecker(bspp6);
            BillServicePeriodPoolChecker bsppc7 = new BillServicePeriodPoolChecker(bspp7);
            BillServicePeriodPoolChecker bsppc8 = new BillServicePeriodPoolChecker(bspp8);
            BillServicePeriodPoolChecker bsppc9 = new BillServicePeriodPoolChecker(bspp9);
            BillServicePeriodPoolChecker bsppc10 = new BillServicePeriodPoolChecker(bspp10);
            BillServicePeriodPoolChecker bsppc11 = new BillServicePeriodPoolChecker(bspp11);
            BillServicePeriodPoolChecker bsppc12 = new BillServicePeriodPoolChecker(bspp12);

            bsppc1.setUpdaterDate(mock(DateSensor.class));
            when(bsppc1.getUpdaterDate().now()).thenReturn(new Date(18, Date.APRIL, 2019));
            bsppc2.setUpdaterDate(mock(DateSensor.class));
            when(bsppc2.getUpdaterDate().now()).thenReturn(new Date(18, Date.APRIL, 2019));
            bsppc3.setUpdaterDate(mock(DateSensor.class));
            when(bsppc3.getUpdaterDate().now()).thenReturn(new Date(18, Date.APRIL, 2019));
            bsppc4.setUpdaterDate(mock(DateSensor.class));
            when(bsppc4.getUpdaterDate().now()).thenReturn(new Date(18, Date.APRIL, 2019));
            bsppc5.setUpdaterDate(mock(DateSensor.class));
            when(bsppc5.getUpdaterDate().now()).thenReturn(new Date(18, Date.APRIL, 2019));
            bsppc6.setUpdaterDate(mock(DateSensor.class));
            when(bsppc6.getUpdaterDate().now()).thenReturn(new Date(18, Date.APRIL, 2019));
            bsppc7.setUpdaterDate(mock(DateSensor.class));
            when(bsppc7.getUpdaterDate().now()).thenReturn(new Date(18, Date.APRIL, 2019));
            bsppc8.setUpdaterDate(mock(DateSensor.class));
            when(bsppc8.getUpdaterDate().now()).thenReturn(new Date(18, Date.APRIL, 2019));
            bsppc9.setUpdaterDate(mock(DateSensor.class));
            when(bsppc9.getUpdaterDate().now()).thenReturn(new Date(3, Date.JUNE, 2019));
            bsppc10.setUpdaterDate(mock(DateSensor.class));
            when(bsppc10.getUpdaterDate().now()).thenReturn(new Date(3, Date.JUNE, 2019));
            bsppc11.setUpdaterDate(mock(DateSensor.class));
            when(bsppc11.getUpdaterDate().now()).thenReturn(new Date(3, Date.JUNE, 2019));
            bsppc12.setUpdaterDate(mock(DateSensor.class));
            when(bsppc12.getUpdaterDate().now()).thenReturn(new Date(3, Date.JUNE, 2019));

            cases = new Object[][] {
                    {bsppc1, bspp1, new BillServicePeriod[]{bsp1}, 1, d1, dateNow, new boolean[] {true}},
                    {bsppc2, bspp2, new BillServicePeriod[]{bsp2}, 2, d1, dateNow, new boolean[] {true}},
                    {bsppc3, bspp3, new BillServicePeriod[]{bsp2}, 1, d2, dateNow, new boolean[] {true}},
                    {bsppc4, bspp4, new BillServicePeriod[]{bsp2}, 2, d1, dateNow, new boolean[] {true}},
                    {bsppc5, bspp5, new BillServicePeriod[]{bsp2, bsp1}, 1, d3, dateNow, new boolean[] {true, false}},
                    {bsppc6, bspp6, new BillServicePeriod[]{bsp2, bsp3}, 2, d1, dateNow, new boolean[] {true, false}},
                    {bsppc7, bspp7, new BillServicePeriod[]{bsp2, bsp1}, 2, d2, dateNow, new boolean[] {true, true}},
                    {bsppc8, bspp8, new BillServicePeriod[]{bsp2, bsp4}, 2, d1, dateNow, new boolean[] {true, false}},
                    {bsppc9, bspp9, new BillServicePeriod[]{bsp2, bsp3, bsp1, bsp4}, 4, d1, dateNow2, new boolean[] {true, true, true, true}},
                    {bsppc10, bspp10, new BillServicePeriod[]{bsp2, bsp3, bsp5, bsp6}, 2, d1, dateNow2, new boolean[] {true, true, false, false}},
                    {bsppc11, bspp11, new BillServicePeriod[]{bsp2, bsp3, bsp7, bsp8}, 2, d1, dateNow2, new boolean[] {true, true, false, false}},
                    {bsppc12, bspp12, new BillServicePeriod[]{bsp2, bsp3, bsp2, bsp9}, 2, d1, dateNow2, new boolean[] {true, true, false, false}}
            };
        } catch(Exception ignored) {}
    }

    private BillServicePeriodPoolChecker billServicePeriodPoolChecker;
    private BillServicePeriodPool billServicePeriodPool;
    private BillServicePeriod[] billServicePeriods;
    private int billTimeLineSize;
    private Date startDate;
    private Date finishDate;
    private boolean[] isAdded;

    public BillServicePeriodPoolCheckerAddBill_(BillServicePeriodPoolChecker billServicePeriodPoolChecker,
                                                BillServicePeriodPool billServicePeriodPool, BillServicePeriod[] billServicePeriods,
                                                int billTimeLineSize, Date startDate, Date finishDate, boolean[] isAdded) {
        this.billServicePeriodPoolChecker = billServicePeriodPoolChecker;
        this.billServicePeriodPool = billServicePeriodPool;
        this.billTimeLineSize = billTimeLineSize;
        this.billServicePeriods = billServicePeriods;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.isAdded = isAdded;
    }

    @Test
    public void execute(){
        boolean[] isAdded = new boolean[this.isAdded.length];
        for (int i = 0; i < billServicePeriods.length; i++) {
            isAdded[i] = billServicePeriodPoolChecker.addBill(billServicePeriods[i]);
        }
        assertThat(billServicePeriodPool.getBillTimeLine().size()).isEqualTo(billTimeLineSize);
        assertThat(billServicePeriodPool.getStartDate()).isEqualTo(startDate);

        assertThat(billServicePeriodPool.getFinishDate().getDay()).isEqualTo(finishDate.getDay());
        assertThat(billServicePeriodPool.getFinishDate().getMonth()).isEqualTo(finishDate.getMonth());
        assertThat(billServicePeriodPool.getFinishDate().getYear()).isEqualTo(finishDate.getYear());

        for (int i = 0; i < isAdded.length; i++) {
            assertThat(isAdded[i]).isEqualTo(this.isAdded[i]);
        }
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return cases;
    }
}