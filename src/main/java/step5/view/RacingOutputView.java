package step5.view;

import step5.domain.result.CarMovementResult;
import step5.domain.result.CarMovementRoundResult;
import step5.domain.result.CarMovementRoundResults;

import java.util.List;

import static step4.util.MyPrinter.lineChange;
import static step4.util.MyPrinter.printLine;

public class RacingOutputView {
    private static final String RESULT_TITLE = "실행결과";
    private static final String MOVE_RECORD_UNIT = "-";
    private static final String MOVE_RECORD_FORMAT = "%s : %s";
    private static final String WINNER_NAME_SEPARATOR = ", ";
    private static final String WINNER_MESSAGE_FORMAT = "%s가 최종 우승했습니다.";

    private RacingOutputView() {
    }

    public static void printRacingResult(CarMovementRoundResults roundResults) {
        printResultTitle();

        roundResults.forEach(RacingOutputView::printRacingRoundResult);

        roundResults.lastRoundResult()
                .ifPresent(RacingOutputView::printRacingWinner);
    }

    public static void printResultTitle() {
        printLine(RESULT_TITLE);
    }

    private static void printRacingRoundResult(CarMovementRoundResult roundResult) {
        roundResult.forEach(RacingOutputView::printRacingResult);
        lineChange();
    }

    private static void printRacingResult(CarMovementResult result) {
        printLine(String.format(MOVE_RECORD_FORMAT, result.carName(), moveRecord(result.moveCount())));
    }

    private static String moveRecord(int moveCount) {
        return MOVE_RECORD_UNIT.repeat(Math.max(0, moveCount));
    }

    private static void printRacingWinner(CarMovementRoundResult result) {
        printLine(String.format(WINNER_MESSAGE_FORMAT, joinWinnerNames(result.winnerNames())));
    }

    private static String joinWinnerNames(List<String> winnerNames) {
        return String.join(WINNER_NAME_SEPARATOR, winnerNames);
    }
}
