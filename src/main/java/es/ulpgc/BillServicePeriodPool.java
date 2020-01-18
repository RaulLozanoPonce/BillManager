package es.ulpgc;

import java.util.SortedSet;
import java.util.TreeSet;

public class BillServicePeriodPool {

    private SortedSet<BillServicePeriod> billTimeLine;
    private Date startDate;
    private Date finishDate;

    public BillServicePeriodPool() {
        this(null, null);
    }

    public BillServicePeriodPool(BillServicePeriod billServicePeriod) {
        this(billServicePeriod.getStartDate(), billServicePeriod.getFinishDate());
        billTimeLine.add(billServicePeriod);
    }

    public BillServicePeriodPool(BillServicePeriod billServicePeriod, Date startDate, Date finishDate) {
        this(startDate, finishDate);
        billTimeLine.add(billServicePeriod);
    }

    public BillServicePeriodPool(Date startDate, Date finishDate) {
        billTimeLine = new TreeSet<>();
        this.startDate = startDate;
        this.finishDate = finishDate;
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
