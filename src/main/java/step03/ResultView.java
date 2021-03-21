package step03;

import java.util.List;

public class ResultView {

    private static final String MOVE_RANGE = "-";
    private static final String DELIMITER = " : ";
    private static final String WINNER_SUFFIX = "가 최종 우승했습니다.";

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
        System.out.println();
    }

    public static void showRacingWinner(String winner) {
        System.out.println(winner + WINNER_SUFFIX);
    }
}
