package racingcar.module;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String CAR_MOVE_DELIMITER = "-";
    private static final String NEW_ROUND_DELIMITER = "\n";
    private static final String NAME_POSITION_DELIMITER = " : ";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printNextRound() {
        System.out.print(NEW_ROUND_DELIMITER);
    }

    public static void printPosition(String name, int position) {
        System.out.print(name + NAME_POSITION_DELIMITER);
        for (int i = 0; i < position; i++) {
            System.out.print(CAR_MOVE_DELIMITER);
        }
        System.out.println();
    }
}
