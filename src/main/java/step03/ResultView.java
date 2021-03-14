package step03;

import java.util.List;

public class ResultView {

    private void showRacingResult(int moveRange) {
        for (int i = 0; i < moveRange; i++) {
            System.out.print("-");
            System.out.println();
        }
    }

    public void showRacingResult(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            showRacingResult(car.getMovingRange());
        }
    }

}
