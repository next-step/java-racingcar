package racingcar;

import java.util.List;

public class ResultView {
    public static void printResult(List<Car> carList) {
        for (Car car : carList) {
            printCarPosition(car);
        }
        System.out.println();
    }

    private static void printCarPosition(Car car) {
        System.out.println(car.makePositionShape());
    }
}
