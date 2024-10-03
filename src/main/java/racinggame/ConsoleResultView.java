package racinggame;

import java.util.List;

public class ConsoleResultView implements ResultView {
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String POSITION_MARKER = "-";
    private static final String ROUND_SEPARATOR = "";

    @Override
    public void printRaceResults(List<Integer> positions) {
        positions.forEach(this::printPosition);
        printRoundSeparator();
    }

    @Override
    public void printResultMessage() {
        printMessage(EXECUTION_RESULT_MESSAGE);
    }

    private void printPosition(int position) {
        String result = POSITION_MARKER.repeat(position);
        printMessage(result);
    }

    private void printRoundSeparator() {
        printMessage(ROUND_SEPARATOR);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
