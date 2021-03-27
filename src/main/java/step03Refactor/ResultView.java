package step03Refactor;

public class ResultView {
    private static final String WINNER_SUFFIX = "가 최종 우승했습니다.";

    private ResultView() {}

    public static void showRacingResult(String racingResult) {
        System.out.print(racingResult);
    }

    public static void showRacingWinner(String racingWinner) {
        System.out.println(racingWinner + WINNER_SUFFIX);
    }
}