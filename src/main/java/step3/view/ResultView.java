package step3.view;

import step3.domain.RacingCar;

public class ResultView {
    public static void printRacingCarsStatus(RacingCar[] racingCars) {
        for (RacingCar racingCar : racingCars) {
            String status = new StringBuilder(racingCar.getName())
                    .append(" : ")
                    .append("-".repeat(racingCar.getDistance()))
                    .toString();
            System.out.println(status);
        }
        System.out.println();
    }

    public static void title() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
