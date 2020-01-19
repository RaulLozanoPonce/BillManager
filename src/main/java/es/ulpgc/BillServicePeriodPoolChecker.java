package es.ulpgc;

import java.util.List;

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

    public boolean isOverlapping(List<BillServicePeriod> billServicePeriodList, BillServicePeriod billServicePeriod) {
        for (int i = 0; i < billServicePeriodList.size(); i++) {
            BillServicePeriod bsp = billServicePeriodList.get(i);
            if(billServicePeriod.getStartDate().compareTo(bsp.getStartDate()) == 0) return true;
            if(billServicePeriod.getFinishDate().compareTo(bsp.getFinishDate()) == 0) return true;
            if(billServicePeriod.getStartDate().compareTo(bsp.getStartDate()) < 0 && billServicePeriod.getFinishDate().compareTo(bsp.getStartDate()) >= 0) return true;
            if(billServicePeriod.getStartDate().compareTo(bsp.getStartDate()) >= 0 && billServicePeriod.getFinishDate().compareTo(bsp.getFinishDate()) <= 0) return true;
            if(billServicePeriod.getStartDate().compareTo(bsp.getFinishDate()) <= 0 && billServicePeriod.getFinishDate().compareTo(bsp.getFinishDate()) > 0) return true;
        }
        return false;
    }

    public boolean isHavingGaps(List<BillServicePeriod> billServicePeriodList, BillServicePeriod billServicePeriod) {
        return true;
    }

    public Date getUpdaterDate() {
        return updaterDate;
    }

    public void setUpdaterDate(Date updaterDate) {
        this.updaterDate = updaterDate;
    }
}
