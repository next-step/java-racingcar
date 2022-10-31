package view;

import racing.RacingGamePrize;
import racing.RacingRecordCar;
import racing.RacingRecordCars;

public class RacingResultView {

    public static void printResult(final RacingGamePrize racingGamePrize, final RacingRecordCars winners) {
        System.out.println("\n실행 결과");

        for (final RacingRecordCars racingCars: racingGamePrize.getRacingRecords()) {
            printCars(racingCars);
            System.out.println();
        }

        printWinners(winners);
    }

    private static void printCars(final RacingRecordCars racingCars) {
        for (final RacingRecordCar racingCar: racingCars.getRacingRecordCars()) {
            printCar(racingCar);
        }
    }

    private static void printCar(final RacingRecordCar racingCar) {
        System.out.println(racingCar.getName() + " : " + "-".repeat(racingCar.getPosition()));
    }

    private static void printWinners(final RacingRecordCars winners) {
        System.out.println(winners.getNames() + "가 최종 우승했습니다.");
    }
}
