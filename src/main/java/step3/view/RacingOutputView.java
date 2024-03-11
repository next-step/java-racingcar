package step3.view;

import java.util.List;

public class RacingOutputView {
    private static final String RESULT_TITLE = "실행결과";
    private static final char MOVE_RECORD_UNIT = '-';

    private RacingOutputView() {

    }

    public static void printResultTitle() {
        printLine(RESULT_TITLE);
    }

    public static void printRacingResult(List<CarMovementResult> results) {
        results.forEach(RacingOutputView::printRacingResult);
        lineChange();
    }

    private static void printRacingResult(CarMovementResult result) {
        for (int i = 0, n = result.moveCount(); i < n; i++) {
            print(MOVE_RECORD_UNIT);
        }
        lineChange();
    }

    private static void printLine(String text) {
        System.out.println(text);
    }

    private static void print(char character) {
        System.out.print(character);
    }

    private static void lineChange() {
        System.out.println();
    }
}
