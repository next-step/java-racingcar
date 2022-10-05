package view;

import racing.RacingCar;
import racing.RacingCars;

import java.util.List;

public class RacingResultView {

    public static void printResult(final List<RacingCars> result) {
        System.out.println("\n실행 결과");

        for (final RacingCars racingCars: result) {
            printCars(racingCars);
            System.out.println();
        }
    }

    private static void printCars(RacingCars racingCars) {
        for (final RacingCar racingCar: racingCars.getRacingCars()) {
            printCar(racingCar);
        }
    }

    private static void printCar(RacingCar racingCar) {
        System.out.println("-".repeat(racingCar.getPosition()));
    }
}
