package racingcar;

import java.util.List;

public class ResultView {

    public static void showResult(RacingCar[] racingCars) {
        for (RacingCar racingCar : racingCars) {
            showCarName(racingCar);
            showLocation(racingCar);
        }
        System.out.printf("\n");
    }

    private static void showCarName(RacingCar racingCar) {
        System.out.printf(racingCar.getName() + " : ");
    }

    private static void showLocation(RacingCar racingCar) {
        for (int i = 0; i < racingCar.getLocation() + 1; i++) {
            System.out.printf("-");
        }
        System.out.printf("\n");

    }

    public static void showWinners(RacingCar[] racingCars) {
        List<String> winners = RacingCarGame.findWinners(racingCars);

        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
