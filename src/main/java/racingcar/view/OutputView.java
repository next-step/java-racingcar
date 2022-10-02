package racingcar.view;

import java.util.List;
import racingcar.Car;

public class OutputView {

    public static void printResult(List<Car> cars, int tryNumber) {
        System.out.println("실행 결과");

        for (int i = 0; i < tryNumber; i++) {
            for (Car car : cars) {
                car.move();
                printCarTrack(car);
            }

            System.out.println();
        }
    }

    private static void printCarTrack(Car car) {
        int totalMoveCount = car.totalMoveCount();
        for (int i = 0; i < totalMoveCount; i++) {
            System.out.print("-");
        }

        System.out.println();
    }
}
