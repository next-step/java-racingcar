package racingcar;

import racingcar.car.Car;

import java.util.List;

public class RacingGameStatusViewer {

    static void showRacingGameStatus(List<Car> cars) {

        for (Car car : cars) {
            printStatusOfEachCar(car.getPosition());
        }
        System.out.println();
    }

    private static void printStatusOfEachCar(int position) {
        for (int p = 0; p <= position; p++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
