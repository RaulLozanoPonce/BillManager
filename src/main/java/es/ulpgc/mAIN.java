package es.ulpgc;

public class mAIN {
    public static void main(String[] args) {
        Date d1 = new Date(1, Date.FEBRUARY, 2019);
        Date d2 = new Date(2, Date.FEBRUARY, 2019);

        System.out.println(d1.adjacentDays(d2));
    }
}
