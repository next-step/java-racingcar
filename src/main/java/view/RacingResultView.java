package view;

import racing.RacingCar;
import racing.RacingCars;

import java.util.List;

public class RacingResultView {

    public static void printResult(final List<RacingCars> result, final RacingCars winners) {
        System.out.println("\n실행 결과");

        for (final RacingCars racingCars: result) {
            printCars(racingCars);
            System.out.println();
        }

        printWinners(winners);
    }

    private static void printCars(RacingCars racingCars) {
        for (final RacingCar racingCar: racingCars.getRacingCars()) {
            printCar(racingCar);
        }
    }

    private static void printCar(RacingCar racingCar) {
        System.out.println(racingCar.getName() + " : " + "-".repeat(racingCar.getPosition()));
    }

    private static void printWinners(RacingCars winners) {
        System.out.println(winners.getNames() + "가 최종 우승했습니다.");
    }
}
