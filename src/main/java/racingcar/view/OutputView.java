package racingcar.view;

import racingcar.Cars;

public class OutputView {

    public static void printResult(Cars cars) {
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
