package step4.utility;

import step4.controller.CarRacing;
import step4.model.CarRecord;

public class ResultView {
    static final int FIRST_ELEMENT = 0;

    public static void resultShow(CarRecord[] cars) {
        for (int i = 0; i < cars[FIRST_ELEMENT].getRecordList().size(); i++) {
            eachTries(i, cars);
        }
        CarRacing.calculateWinner(cars);
    }

    private static void eachTries(int i, CarRecord[] cars) {
        for (int l = 0; l < cars.length; l++) {
            System.out.print(cars[l].getCarName() + ": ");

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
