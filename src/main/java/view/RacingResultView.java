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

        System.out.println(winnersResult(winners));
    }

    private static void printCars(RacingCars racingCars) {
        for (final RacingCar racingCar: racingCars.getRacingCars()) {
            System.out.println(carResult(racingCar));
        }
    }

    public static String carResult(RacingCar racingCar) {
        return racingCar.getName() + " : " + "-".repeat(racingCar.getPosition());
    }

    public static String winnersResult(RacingCars winners) {
        return winners.getNames() + "가 최종 우승했습니다.";
    }
}
