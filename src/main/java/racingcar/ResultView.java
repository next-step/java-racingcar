package racingcar;

public class ResultView {
    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String FORWARD = "-";

    private ResultView() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void printExecuteResult() {
        System.out.println();
        System.out.println(EXECUTE_RESULT);
    }

    public static void print(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            System.out.print(FORWARD);
        }
        System.out.println();
    }

    public static void nextAttempt() {
        System.out.println();
    }
}
