package racingcar.view;

import racingcar.Car;
import racingcar.Cars;

public class OutputView {

    public static void printResult(Cars cars) {
        cars.moveAll();
        cars.carList().forEach(car -> printCarTrack(car.totalMoveCount()));

        System.out.println();
    }

    public static void printCarTrack(int totalMoveCount) {
        for (int i = 0; i < totalMoveCount; i++) {
            System.out.print("-");
        }

        System.out.println();
    }
}
