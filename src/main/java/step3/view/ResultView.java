package step3.view;

import step3.domain.RacingPosition;
import step3.domain.RacingWinner;

public class ResultView {

    private static final String RESULT_TITLE = "==============";
    private static final String WINNER_NAME_DELIMITER = ",";

    private ResultView() {
    }

    public static void printPosition(RacingPosition racingPosition) {
        System.out.println(RESULT_TITLE);
        racingPosition.getPositions().forEach(System.out::println);
    }

    public static void printWinner(RacingWinner racingWinner) {
        System.out.println(String.join(WINNER_NAME_DELIMITER, racingWinner.getNames()) + "가 최종 우승했습니다.");
    }
}
