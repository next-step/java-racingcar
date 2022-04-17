package racingcar.view;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String CAR_MOVE_DELIMITER = "-";
    private static final String NEW_ROUND_DELIMITER = "\n";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printNextRound() {
        System.out.println(NEW_ROUND_DELIMITER);
    }

    public static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(CAR_MOVE_DELIMITER);
        }
        System.out.println();
    }
}
