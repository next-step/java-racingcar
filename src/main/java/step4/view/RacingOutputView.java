package step4.view;

import step4.view.result.CarMovementResult;
import step4.view.result.CarMovementRoundResult;
import step4.view.result.CarMovementRoundResults;

import static step4.util.MyPrinter.*;

public class RacingOutputView {
    private static final String RESULT_TITLE = "실행결과";
    private static final String MOVE_RECORD_UNIT = "-";
    private static final String MOVE_RECORD_FORMAT = "%s : %s";

    private RacingOutputView() {
    }

    public static void printRacingResult(CarMovementRoundResults roundResults) {
        printResultTitle();
        roundResults.forEach(RacingOutputView::printRacingRoundResult);
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
}
