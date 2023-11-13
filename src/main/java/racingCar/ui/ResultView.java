package racingCar.ui;

import racingCar.car.Car;
import racingCar.car.Cars;

import java.util.List;

public class ResultView {
    public static String RESULT_PREFIX = "실행 결과";

    public static void printPrefix() {
        System.out.println();
        System.out.println(ResultView.RESULT_PREFIX);
    }

    public static void printDistance(Cars cars) {
        List<Car> carList = cars.carList();
        for (Car car : carList) {
            System.out.println("-".repeat(car.distance));
        }
        System.out.println();
    }
}
