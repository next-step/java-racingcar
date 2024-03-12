package racingcar.view;

import java.util.List;
import racingcar.domain.Winners;
import racingcar.domain.dto.DriveResult;
import racingcar.domain.dto.RoundResult;

public class OutputView {

    public static final String DISTANCE_INDICATOR_SIGN = "-";
    private static final String WINNER_DELIMITER = ", ";

    public static final String ROUND_RESULT_MESSAGE = "%s : %s\n";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_ANNOUNCEMENT_MESSAGE = "%s가 최종 우승했습니다.";

    public void printRoundResultHeader() {
        printLine();
        System.out.println(RESULT_MESSAGE);
    }

    public void printRoundResult(RoundResult roundResult) {
        List<DriveResult> driveResults = roundResult.driveResults();
        for (DriveResult driveResult : driveResults) {
            System.out.printf(
                ROUND_RESULT_MESSAGE,
                driveResult.name(),
                distanceIndicator(driveResult.drivingDistance())
            );
        }
        printLine();
    }

    private String distanceIndicator(int drivingDistance) {
        return DISTANCE_INDICATOR_SIGN.repeat(drivingDistance);
    }

    public void printWinners(Winners winners) {
        System.out.printf(
            WINNER_ANNOUNCEMENT_MESSAGE,
            String.join(WINNER_DELIMITER, winners.names())
        );
    }

    private void printLine() {
        System.out.println();
    }
}
