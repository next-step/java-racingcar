package racingcar.view;

import java.util.List;

public class OutputView {

    public static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String EXECUTION_RESULT = "실행 결과";

    public void printGameResultMessage() {
        System.out.println(EXECUTION_RESULT);
    }

    public void printGameResult(List<String> gameResults) {
        gameResults.forEach(System.out::print);
    }

    public void printWinners(String winners) {
        System.out.printf(WINNER_MESSAGE, winners);
    }
}
