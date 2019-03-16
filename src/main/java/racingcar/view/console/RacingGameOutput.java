package racingcar.view.console;

import racingcar.domain.RacingCar;

import java.util.List;

public class RacingGameOutput {

    public static void showRaceOf(final List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> System.out.println(racingCar.getPositionAsText()));
        System.out.println();
    }

    public static void showWinners(final List<RacingCar> winners) {
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());

            printComma(i, winners.size());
        }

        System.out.print("가 최종 우승했습니다.");
    }

    private static void printComma(final int i, final int size) {
        if (i + 1 < size) {
            System.out.print(", ");
        }
    }
}
