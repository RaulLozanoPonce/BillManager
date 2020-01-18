package es.ulpgc;

import java.util.SortedSet;
import java.util.TreeSet;

public class BillServicePeriodPool {

    private SortedSet<BillServicePeriod> billTimeLine;
    private Date startDate;
    private Date finishDate;

    public BillServicePeriodPool() {
        billTimeLine = new TreeSet<>();
        startDate = null;
        finishDate = null;
    }

    public BillServicePeriodPool(BillServicePeriod billServicePeriod) {
    }

    public SortedSet<BillServicePeriod> getBillTimeLine() {
        return billTimeLine;
    }

    public void setBillTimeLine(SortedSet<BillServicePeriod> billTimeLine) {
        this.billTimeLine = billTimeLine;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
}
