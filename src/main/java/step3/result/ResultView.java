package step3.result;

import step3.racingcar.RacingCar;

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
}
