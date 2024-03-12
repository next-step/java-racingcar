package racingcar.view;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.domain.dto.DriveResult;
import racingcar.domain.dto.RoundResult;

public class OutputView {

    private static final String WINNER_DELIMITER = ", ";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_ANNOUNCEMENT_MESSAGE = "%s가 최종 우승했습니다.";

    public void printResult(List<RoundResult> roundResults) {
        printLine();
        System.out.println(RESULT_MESSAGE);
        for (RoundResult roundResult : roundResults) {
            for (DriveResult driveResult : roundResult.driveResults()) {
                System.out.printf("%s : %s\n", driveResult.name(), "-".repeat(driveResult.drivingDistance()));
            }
            printLine();
        }
    }

    public void printWinners(List<String> winnerNames) {
        printLine();
        System.out.printf(WINNER_ANNOUNCEMENT_MESSAGE,
            String.join(WINNER_DELIMITER, winnerNames));
    }

    private void printLine() {
        System.out.println();
    }
}
