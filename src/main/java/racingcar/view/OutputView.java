package racingcar.view;

public class OutputView {

    private static final String EXECUTION_RESULT = "실행 결과";
    public static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";

    public void printGameResultMessage() {
        System.out.println(EXECUTION_RESULT);
    }

    public void printSingleGameResult(String gameResult) {
        System.out.print(gameResult);
    }

    public void printWinners(String winners) {
        System.out.printf(WINNER_MESSAGE, winners);
    }
}
