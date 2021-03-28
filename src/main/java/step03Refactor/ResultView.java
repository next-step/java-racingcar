package step03Refactor;

import static step03Refactor.Config.WINNER_SUFFIX;

public class ResultView {

    private ResultView() {}

    public static void showRacingResult(String racingResult) {
        System.out.print(racingResult);
    }

    public static void showRacingWinner(String racingWinner) {
        System.out.println(racingWinner + WINNER_SUFFIX);
    }
}