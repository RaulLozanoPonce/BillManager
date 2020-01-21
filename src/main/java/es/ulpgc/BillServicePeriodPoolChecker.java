package es.ulpgc;

import java.util.ArrayList;
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
            List<BillServicePeriod> billServicePeriodList = new ArrayList<>(billServicePeriodPool.getBillTimeLine());
            if(!isOverlapping(billServicePeriodList, billServicePeriod) && !isHavingGaps(billServicePeriodList, billServicePeriod)) {
                if (billServicePeriodPool.getStartDate() == null) {
                    if (billServicePeriodPool.getBillTimeLine().add(billServicePeriod)) {
                        billServicePeriodPool.setStartDate(billServicePeriod.getStartDate());
                        return true;
                    }
                } else if (billServicePeriod.getFinishDate().compareTo(billServicePeriodPool.getStartDate()) >= 0) {
                    return billServicePeriodPool.getBillTimeLine().add(billServicePeriod);
                }
            }
        }
        return false;
    }

    public boolean isOverlapping(List<BillServicePeriod> billServicePeriodList, BillServicePeriod billServicePeriod) {
        if(billServicePeriodList.size() > 0) {
            Date startDateList = billServicePeriodList.get(0).getStartDate();
            Date finishDateList = billServicePeriodList.get(billServicePeriodList.size() - 1).getFinishDate();
            Date startDateNew = billServicePeriod.getStartDate();
            Date finishDateNew = billServicePeriod.getFinishDate();

            if((startDateNew.compareTo(startDateList) < 0 && finishDateNew.compareTo(startDateList) < 0) ||
                    (startDateNew.compareTo(finishDateList) > 0 && finishDateNew.compareTo(finishDateList) > 0)) {
                return false;
            }

            if((startDateNew.compareTo(finishDateList) < 0 && finishDateNew.compareTo(finishDateList) == 0) ||
                    (startDateNew.compareTo(startDateList) == 0 && finishDateNew.compareTo(finishDateList) == 0) ||
                    (startDateNew.compareTo(startDateList) == 0 && finishDateNew.compareTo(finishDateList) > 0)) {
                return true;
            }

            if((startDateNew.compareTo(startDateList) < 0 && finishDateNew.compareTo(startDateList) == 0) ||
                    (startDateNew.compareTo(finishDateList) == 0 && finishDateNew.compareTo(finishDateList) > 0)) {
                return true;
            }

            if(startDateNew.compareTo(startDateList) > 0 && finishDateNew.compareTo(startDateList) > 0 &&
                    startDateNew.compareTo(finishDateList) < 0 && finishDateNew.compareTo(finishDateList) < 0) {
                return true;
            }

            if(startDateNew.compareTo(startDateList) < 0 && finishDateNew.compareTo(startDateList) > 0 && finishDateNew.compareTo(finishDateList) < 0) {
                return true;
            }

            if(startDateNew.compareTo(startDateList) > 0 && startDateNew.compareTo(finishDateList) < 0 && finishDateNew.compareTo(finishDateList) > 0) {
                return true;
            }

            if(startDateNew.compareTo(startDateList) < 0 && finishDateNew.compareTo(finishDateList) > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isHavingGaps(List<BillServicePeriod> billServicePeriodList, BillServicePeriod billServicePeriod) {
        if(billServicePeriodList.size() > 0) {
            return billServicePeriod.getFinishDate().adjacentDays(billServicePeriodList.get(0).getStartDate()) == -2 ||
                    billServicePeriod.getStartDate().adjacentDays(billServicePeriodList.get(billServicePeriodList.size() - 1).getFinishDate()) == 2;
        }
        return false;
    }

    public Date getUpdaterDate() {
        return updaterDate;
    }

    public void setUpdaterDate(Date updaterDate) {
        this.updaterDate = updaterDate;
    }
}
