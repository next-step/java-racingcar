package view;

import racing.RacingCar;
import racing.RacingCars;
import racing.RacingGamePrize;

public class RacingResultView {

    public static void printResult(final RacingGamePrize racingGamePrize, final RacingCars winners) {
        System.out.println("\n실행 결과");

        for (final RacingCars racingCars: racingGamePrize.getRacingResult()) {
            printCars(racingCars);
            System.out.println();
        }

        printWinners(winners);
    }

    private static void printCars(final RacingCars racingCars) {
        for (final RacingCar racingCar: racingCars.getRacingCars()) {
            printCar(racingCar);
        }
    }

    private static void printCar(final RacingCar racingCar) {
        System.out.println(racingCar.getName() + " : " + "-".repeat(racingCar.getPosition()));
    }

    private static void printWinners(final RacingCars winners) {
        System.out.println(winners.getNames() + "가 최종 우승했습니다.");
    }
}
