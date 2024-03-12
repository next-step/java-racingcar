package racingcar.view;

import racingcar.domain.RacingGame;

public class OutputView {

    private static final String WINNER_DELIMITER = ", ";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_ANNOUNCEMENT_MESSAGE = "%s가 최종 우승했습니다.";

    public void printResult(RacingGame racingGame) {
        printLine();
        System.out.println(RESULT_MESSAGE);
        System.out.println(racingGame.result());
    }

    public void printWinners(RacingGame racingGame) {
        printLine();
        System.out.printf(WINNER_ANNOUNCEMENT_MESSAGE,
            String.join(WINNER_DELIMITER, racingGame.winnerNames()));
    }

    private void printLine() {
        System.out.println();
    }
}
