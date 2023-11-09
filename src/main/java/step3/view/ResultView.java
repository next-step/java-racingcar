package step3.view;

import step3.domain.RacingCar;

public class ResultView {
    public static void printResult(RacingCar[] racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.println("-".repeat(racingCar.getDistance()));
        }
        System.out.println();
    }

    public static void title() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
