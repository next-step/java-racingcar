package racingcar.view;

import racingcar.entity.Name;
import racingcar.entity.RacingCar;
import racingcar.entity.RacingCars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printWinners(List<Name> winners) {
        String winnerListWithComma = String.join(",", winners.stream().map(winner -> winner.getName()).collect(Collectors.toList()));
        System.out.print(winnerListWithComma);
        System.out.println("가 최종 우승했습니다.");
    }

    public static void printRacingCarsPosition(RacingCars racingCars) {
        for (RacingCar racingCar: racingCars.getRacingCars()) {
            printName(racingCar.getName());
            printPosition(racingCar.getPosition());
        }
        System.out.println();
    }

    private static void printName(Name name) {
        System.out.print(name.getName() + " : ");
    }

    private static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public static void printResultFirstLine() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
