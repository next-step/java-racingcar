package step4.utility;

import step4.model.Car;
import step4.model.Cars;
import step4.model.Winners;

public class ResultView {

    public static void resultShow(Cars cars, int numOfTries) {
        for (int i = 0; i < numOfTries; i++) {
            eachTries(i, cars);
            System.out.println();
        }

        Winners winners = cars.findWinners();
        System.out.println("최종 승자는 "+ winners.createWinnerNames());
    }

    private static void eachTries(int i, Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.print(car.getName() + ": ");
            ResultView.eachCarRecord(car.getRecordMove(i));
        }
    }

    private static void eachCarRecord(int length) {
        for (int j = 0; j < length; j++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
