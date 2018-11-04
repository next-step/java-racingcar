package racing.view;

import racing.Car;

import java.util.List;

public class ResultView {

    public static void showResult(List<Car> cars, int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            showEachCarRecord(cars, i);
        }
    }

    private static void showEachCarRecord(List<Car> cars, int carNum) {
        for (Car car : cars) {
            int record = (int)car.getRecord().get(carNum);
            showEachRecord(record);
        }
        System.out.println();
    }

    private static void showEachRecord(int record) {
        for (int j = 0; j < record; j++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
