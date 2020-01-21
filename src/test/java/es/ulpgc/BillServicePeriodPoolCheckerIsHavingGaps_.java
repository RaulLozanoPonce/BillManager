package es.ulpgc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class BillServicePeriodPoolCheckerIsHavingGaps_ {

    private static Object[][] cases;

    static {
        BillServicePeriodPoolChecker bsppc = new BillServicePeriodPoolChecker(new BillServicePeriodPool());

        Date d1 = new Date(1, Date.FEBRUARY, 2019);
        Date d2 = new Date(3, Date.MARCH, 2019);
        Date d3 = new Date(4, Date.MARCH, 2019);
        Date d4 = new Date(6, Date.APRIL, 2019);
        Date d5 = new Date(7, Date.APRIL, 2019);
        Date d6 = new Date(4, Date.MAY, 2019);

        Date d7 = new Date(4, Date.DECEMBER, 2018);
        Date d8 = new Date(1, Date.JANUARY, 2019);

        Date d9 = new Date(2, Date.JANUARY, 2019);
        Date d10 = new Date(31, Date.JANUARY, 2019);

        Date d11 = new Date(7, Date.MARCH, 2019);
        Date d12 = new Date(10, Date.APRIL, 2019);

        Date d13 = new Date(5, Date.MAY, 2019);
        Date d14 = new Date(2, Date.JUNE, 2019);

        Date d15 = new Date(3, Date.JUNE, 2019);
        Date d16 = new Date(7, Date.JULY, 2019);

        List<BillServicePeriod> billServicePeriodList = new ArrayList<>();
        billServicePeriodList.add(new BillServicePeriod(d1, d2));
        billServicePeriodList.add(new BillServicePeriod(d3, d4));
        billServicePeriodList.add(new BillServicePeriod(d5, d6));

        cases = new Object[][] {
                {bsppc, billServicePeriodList, new BillServicePeriod(d7, d8), true},
                {bsppc, billServicePeriodList, new BillServicePeriod(d9, d10), false},
                {bsppc, billServicePeriodList, new BillServicePeriod(d3, d4), false},
                {bsppc, billServicePeriodList, new BillServicePeriod(d11, d12), false},
                {bsppc, billServicePeriodList, new BillServicePeriod(d13, d14), false},
                {bsppc, billServicePeriodList, new BillServicePeriod(d15, d16), true}
        };
    }

    private BillServicePeriodPoolChecker billServicePeriodPoolChecker;
    private List<BillServicePeriod> billServicePeriodList;
    private BillServicePeriod billServicePeriod;
    private boolean isHavingGaps;

    public BillServicePeriodPoolCheckerIsHavingGaps_(BillServicePeriodPoolChecker billServicePeriodPoolChecker,
                                                     List<BillServicePeriod> billServicePeriodList,
                                                     BillServicePeriod billServicePeriod, boolean isHavingGaps) {
        this.billServicePeriodPoolChecker = billServicePeriodPoolChecker;
        this.billServicePeriodList = billServicePeriodList;
        this.billServicePeriod = billServicePeriod;
        this.isHavingGaps = isHavingGaps;
    }

    @Test
    public void execute(){
        assertThat(billServicePeriodPoolChecker.isHavingGaps(billServicePeriodList, billServicePeriod)).isEqualTo(isHavingGaps);
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return cases;
    }
}
