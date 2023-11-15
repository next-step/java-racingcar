package racingCar.view;

import racingCar.domain.Distance;

public class ResultView {

    public static void executionResultSign() {
        System.out.println("실행 결과");
    }

    public static void showDistance(Distance distance) {
        System.out.println("-".repeat(distance.getDistance()));
    }

    public static void showNextRound() {
        System.out.println();
    }

}
