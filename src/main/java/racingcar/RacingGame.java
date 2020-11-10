package racingcar;

import racingcar.controller.RacingController;

import java.util.List;

public class RacingGame {
    public static void main(String[] args) {
        try {
            executeGame();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void executeGame() {
        List<String> carNames = RacingController.getCarNames();
        int gameRoundNum = RacingController.getGameRoundNum();

        RacingController.showResult(RacingController.execute(carNames, gameRoundNum));
    }
}
