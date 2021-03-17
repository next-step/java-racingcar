package step03;

import java.util.List;

public class ResultView {

    private ResultView() {}

    private static void showRacingResult(int moveRange) {
        for (int i = 0; i < moveRange; i++) {
            System.out.print("-");
        }
    }

    public static void showRacingResult(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            showRacingResult(car.getMovingRange());
            System.out.println();
        }
    }

}
