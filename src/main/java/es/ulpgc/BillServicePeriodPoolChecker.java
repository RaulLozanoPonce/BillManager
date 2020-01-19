package es.ulpgc;

public class BillServicePeriodPoolChecker {

    private final BillServicePeriodPool billServicePeriodPool;
    private Date updaterDate;

    public BillServicePeriodPoolChecker(BillServicePeriodPool billServicePeriodPool) {
        this.billServicePeriodPool = billServicePeriodPool;
        this.updaterDate = new Date();
    }

    /*public boolean addBill(BillServicePeriod billServicePeriod) {
        Date dateNow = updaterDate.now();
        billServicePeriodPool.setFinishDate(dateNow);
        if(billServicePeriodPool.getStartDate() == null) {
            if(billServicePeriod.getFinishDate().compareTo(dateNow) < 0) {
                boolean isAdded = billServicePeriodPool.getBillTimeLine().add(billServicePeriod);
                if(isAdded) {
                    billServicePeriodPool.setStartDate(billServicePeriod.getStartDate());
                }
                return isAdded;
            } else {
                return false;
            }
        } else {
            if (billServicePeriod.getFinishDate().compareTo(billServicePeriodPool.getStartDate()) >= 0 &&
                    billServicePeriod.getFinishDate().compareTo(dateNow) <= 0) {
                return billServicePeriodPool.getBillTimeLine().add(billServicePeriod);
            } else {
                return false;
            }
        }
    }*/
    public boolean addBill(BillServicePeriod billServicePeriod) {
        Date dateNow = updaterDate.now();
        billServicePeriodPool.setFinishDate(dateNow);
        if(billServicePeriod.getFinishDate().compareTo(dateNow) > 0) return false;
        if(billServicePeriodPool.getStartDate() == null) {
            if(billServicePeriodPool.getBillTimeLine().add(billServicePeriod)) {
                billServicePeriodPool.setStartDate(billServicePeriod.getStartDate());
                return true;
            }
            return false;
        } else if (billServicePeriod.getFinishDate().compareTo(billServicePeriodPool.getStartDate()) >= 0) {
            return billServicePeriodPool.getBillTimeLine().add(billServicePeriod);
        }
        return false;
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
