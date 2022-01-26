package racingcar.view;

public class ResultView {

    private static final String ENTER = "\n";
    private static final String HEAD_MESSAGE = ENTER + "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자: ";

    public static void printRacingResult(final String result) {
        System.out.println(HEAD_MESSAGE);
        System.out.print(result);
    }

    public static void printWinner(final String winner) {
        System.out.print(FINAL_WINNER_MESSAGE);
        System.out.print(winner);
    }
}
