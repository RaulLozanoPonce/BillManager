package es.ulpgc;

public class BillServicePeriodPoolChecker {

    private final BillServicePeriodPool billServicePeriodPool;
    private Date updaterDate;

    public BillServicePeriodPoolChecker(BillServicePeriodPool billServicePeriodPool) {
        this.billServicePeriodPool = billServicePeriodPool;
        this.updaterDate = new Date();
    }

    public boolean addBill(BillServicePeriod billServicePeriod) {
        if(billServicePeriodPool.getStartDate() == null)
            billServicePeriodPool.setStartDate(billServicePeriod.getStartDate());
        billServicePeriodPool.setFinishDate(updaterDate.now());
        return billServicePeriodPool.getBillTimeLine().add(billServicePeriod);
    }

    public boolean isOverlapping() {
        return true;
    }

    public boolean isHavingGaps() {
        return true;
    }

    public Date getUpdaterDate() {
        return updaterDate;
    }

    public void setUpdaterDate(Date updaterDate) {
        this.updaterDate = updaterDate;
    }
}
