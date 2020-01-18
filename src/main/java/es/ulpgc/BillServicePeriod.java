package es.ulpgc;

public class BillServicePeriod implements Comparable<BillServicePeriod> {

    private final Date startDate;
    private final Date finishDate;

    public BillServicePeriod(Date startDate, Date finishDate) {
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    @Override
    public int compareTo(BillServicePeriod billServicePeriod) {
        return 0;
    }
}
