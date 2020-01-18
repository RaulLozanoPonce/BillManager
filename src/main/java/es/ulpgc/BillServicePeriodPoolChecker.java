package es.ulpgc;

public class BillServicePeriodPoolChecker {

    private final BillServicePeriodPool billServicePeriodPool;

    public BillServicePeriodPoolChecker(BillServicePeriodPool billServicePeriodPool) {
        this.billServicePeriodPool = billServicePeriodPool;
    }

    public boolean addBill(BillServicePeriod billServicePeriod) {
        if(billServicePeriodPool.getStartDate() == null)
            billServicePeriodPool.setStartDate(billServicePeriod.getStartDate());
        billServicePeriodPool.setFinishDate(new Date().now());
        return billServicePeriodPool.getBillTimeLine().add(billServicePeriod);
    }

    public boolean isOverlapping() {
        return true;
    }

    public boolean isHavingGaps() {
        return true;
    }
}
