package racingcar.view;

import racingcar.dto.RaceResult;

public class ResultView {
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    public static final String WINNER_ANNOUNCEMENT_MESSAGE = "가 최종 우승했습니다.";
    public static final String LINE_SEPARATOR = System.lineSeparator();

    private ResultView() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void print(final RaceResult raceResult) {
        String result = LINE_SEPARATOR + EXECUTION_RESULT_MESSAGE + LINE_SEPARATOR +
                raceResult.formatAttempts(LINE_SEPARATOR) +
                raceResult.joinWinners() + WINNER_ANNOUNCEMENT_MESSAGE;
        System.out.print(result);
    }

}
