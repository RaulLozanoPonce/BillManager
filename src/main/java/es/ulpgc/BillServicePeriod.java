package es.ulpgc;

public class BillServicePeriod implements Comparable<BillServicePeriod> {

    private final Date startDate;
    private final Date finishDate;

    public BillServicePeriod(Date startDate, Date finishDate) throws InvalidBillServicePeriod {
        if(finishDate.compareTo(startDate) <= 0) throw new InvalidBillServicePeriod();
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
        if(startDate.compareTo(billServicePeriod.getStartDate()) < 0) return -1;
        if(startDate.compareTo(billServicePeriod.getStartDate()) > 0) return 1;
        if(finishDate.compareTo(billServicePeriod.getFinishDate()) < 0) return -1;
        if(finishDate.compareTo(billServicePeriod.getFinishDate()) > 0) return 1;
        return 0;
    }

    public class InvalidBillServicePeriod extends Exception {

    }
}
