package racingcar;

public class ResultView {
    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String FORWARD = "-";

    private ResultView() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void printHistory(int[][] histories) {
        StringBuilder result = new StringBuilder();
        result.append("\n" + EXECUTE_RESULT + "\n");
        for (int[] history : histories) {
            appendPosition(history, result);
        }
        System.out.print(result);
    }

    private static void appendPosition(int[] history, StringBuilder result) {
        for (int position : history) {
            result.append(FORWARD.repeat(Math.max(0, position))).append("\n");
        }
        result.append("\n");
    }
}
