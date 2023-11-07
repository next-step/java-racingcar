package step4.result;

import step4.racingcar.RacingCar;

import java.util.List;

public class ResultView {
    public static void printTryResult(final List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println(car.toString());
        }

        System.out.println();
    }

    public static void printResultText() {
        System.out.println("실행 결과");
    }

    public static void printWinners(final String[] winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
