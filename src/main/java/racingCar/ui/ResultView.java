package racingCar.ui;

import racingCar.Car;

import java.util.List;

public class ResultView {
    public static String RESULT_PREFIX = "실행 결과";

    public static void printPrefix() {
        System.out.println();
        System.out.println(ResultView.RESULT_PREFIX);
    }

    public static void printDistance(List<Car> carList) {
        for (Car car : carList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("-".repeat(car.distance));
            System.out.println(stringBuilder);
        }
        System.out.println();
    }
}
