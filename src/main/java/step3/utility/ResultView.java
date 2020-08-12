package step3.utility;

import step3.model.CarRecord;

public class ResultView {
    static final int FIRST_ELEMENT = 0;

    public static void resultShow(CarRecord[] cars) {
        for (int i = 0; i < cars[FIRST_ELEMENT].getRecordList().size(); i++) {
            eachTries(i, cars);
        }
    }

    private static void eachTries(int i, CarRecord[] cars) {
        for (int l = 0; l < cars.length; l++) {
            int length = cars[l].getRecordList().get(i);
            ResultView.eachCarRecord(length);
        }
        System.out.println();
    }

    private static void eachCarRecord(int length) {
        for (int j = 0; j < length; j++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
