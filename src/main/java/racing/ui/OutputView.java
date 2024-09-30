package racing.ui;

import java.util.List;
import racing.domain.GameResult;

public class OutputView {

    private static final String OUTPUT_START_MESSAGE = "실행 결과";

    public static void printGameResults(List<GameResult> results) {
        printBlankLine();
        printStartMessage();
        for (GameResult result : results) {
            printResult(result);
            printBlankLine();
        }
    }

    private static void printResult(GameResult result) {
        for (int position : result.getRoundResult()) {
            System.out.println(convertPositionToGage(position));
        }
    }

    private static String convertPositionToGage(int position) {
        StringBuilder positionGage = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionGage.append("-");
        }
        return positionGage.toString();
    }

    private static void printBlankLine() {
        System.out.println();
    }

    private static void printStartMessage() {
        System.out.println(OUTPUT_START_MESSAGE);
    }
}
