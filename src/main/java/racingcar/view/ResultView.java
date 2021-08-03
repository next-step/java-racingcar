package racingcar.view;

import racingcar.entity.RacingCar;

import java.util.List;

public class ResultView {
    public static void printWinners(List<String> winners) {
        String winnerListWithComma = String.join(",", winners);
        System.out.print(winnerListWithComma);
        System.out.println("가 최종 우승했습니다.");
    }

    public static void printRacingCarsPosition(List<RacingCar> racingCars) {
        for (RacingCar racingCar: racingCars) {
            printName(racingCar.getName());
            printPosition(racingCar.getPosition());
        }
        System.out.println();
    }

    private static void printName(String name) {
        System.out.print(name + " : ");
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
