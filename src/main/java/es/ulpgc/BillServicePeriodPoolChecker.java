package es.ulpgc;

import java.util.List;

public class BillServicePeriodPoolChecker {

    private final BillServicePeriodPool billServicePeriodPool;
    private Date updaterDate;

    public BillServicePeriodPoolChecker(BillServicePeriodPool billServicePeriodPool) {
        this.billServicePeriodPool = billServicePeriodPool;
        this.updaterDate = new Date();
    }

    public boolean addBill(BillServicePeriod billServicePeriod) {
        Date dateNow = updaterDate.now();
        billServicePeriodPool.setFinishDate(dateNow);
        if(billServicePeriod.getFinishDate().compareTo(dateNow) <= 0) {
            if (billServicePeriodPool.getStartDate() == null) {
                if (billServicePeriodPool.getBillTimeLine().add(billServicePeriod)) {
                    billServicePeriodPool.setStartDate(billServicePeriod.getStartDate());
                    return true;
                }
            } else if (billServicePeriod.getFinishDate().compareTo(billServicePeriodPool.getStartDate()) >= 0) {
                return billServicePeriodPool.getBillTimeLine().add(billServicePeriod);
            }
        }
        return false;
    }

    public boolean isOverlapping(List<BillServicePeriod> billServicePeriodList, BillServicePeriod billServicePeriod) {
        if(billServicePeriod.getStartDate().compareTo(billServicePeriodList.get(0).getStartDate()) == 0) return true;
        if(billServicePeriod.getFinishDate().compareTo(billServicePeriodList.get(billServicePeriodList.size() - 1).getFinishDate()) == 0) return true;
        if(billServicePeriod.getStartDate().compareTo(billServicePeriodList.get(0).getStartDate()) < 0 &&
                billServicePeriod.getFinishDate().compareTo(billServicePeriodList.get(0).getStartDate()) >= 0) return true;
        if(billServicePeriod.getStartDate().compareTo(billServicePeriodList.get(0).getStartDate()) >= 0 &&
                billServicePeriod.getFinishDate().compareTo(billServicePeriodList.get(billServicePeriodList.size() - 1).getFinishDate()) <= 0) return true;
        if(billServicePeriod.getStartDate().compareTo(billServicePeriodList.get(0).getFinishDate()) <= 0 &&
                billServicePeriod.getFinishDate().compareTo(billServicePeriodList.get(billServicePeriodList.size() - 1).getFinishDate()) > 0) return true;
        return false;
    }

    public boolean isHavingGaps(List<BillServicePeriod> billServicePeriodList, BillServicePeriod billServicePeriod) {
        return billServicePeriod.getFinishDate().adjacentDays(billServicePeriodList.get(0).getStartDate()) == -2 ||
                billServicePeriod.getStartDate().adjacentDays(billServicePeriodList.get(billServicePeriodList.size() - 1).getFinishDate()) == 2;
    }

    public Date getUpdaterDate() {
        return updaterDate;
    }

    public void setUpdaterDate(Date updaterDate) {
        this.updaterDate = updaterDate;
    }
}
