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
        System.out.print("\n" + EXECUTE_RESULT + "\n");
        for (int[] history : histories) {
            for (int position : history) {
                System.out.print(ResultView.printPosition(position) + "\n");
            }
            System.out.print("\n");
        }
    }
}
