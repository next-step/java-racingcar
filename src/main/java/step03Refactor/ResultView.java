package step03Refactor;

import java.util.List;

import static step03Refactor.Config.WINNER_SUFFIX;

public class ResultView {

    private ResultView() {}

    public static void showRacingResult(List<CarDTO> carDatas) {
        for (CarDTO carData: carDatas) {
            System.out.println(carData.toString());
        }
    }

    public static void showRacingWinner(String racingWinner) {
        System.out.println(racingWinner + WINNER_SUFFIX);
    }
}