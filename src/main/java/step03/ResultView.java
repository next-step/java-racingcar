package step03;

import java.util.List;

public class ResultView {

    private static final String MOVE_RANGE = "-";
    private static final String DELIMITER = " : ";

    private ResultView() {}

    private static void showRacingResult(RacingCarDTO racingCarDTO) {
        System.out.print(racingCarDTO.getCarName() + DELIMITER);
        for (int i = 0; i < racingCarDTO.getMovingRange(); i++) {
            System.out.print(MOVE_RANGE);
        }
    }

    public static void showRacingResult(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            showRacingResult(car.getRacingCarData());
            System.out.println();
        }
    }

}
