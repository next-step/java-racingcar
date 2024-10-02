package racingcar;

public class ResultView {
    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String FORWARD = "-";

    private ResultView() {
        throw new UnsupportedOperationException("Utility class");
    }

    private static String printPosition(int position) {
        return FORWARD.repeat(Math.max(0, position));
    }

    public static void printHistory(int[][] histories) {
        StringBuilder result = new StringBuilder();
        result.append("\n" + EXECUTE_RESULT + "\n");
        for (int[] history : histories) {
            for (int position : history) {
                result.append(ResultView.printPosition(position)).append("\n");
            }
            result.append("\n");
        }
        System.out.print(result);
    }
}
