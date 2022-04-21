package racingcar.module;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String CAR_MOVE_DELIMITER = "-";
    private static final String NEW_ROUND_DELIMITER = "\n";
    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String WINNER_PHRASE = "가 최종 우승했습니다.";

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

    public static void printWinners(List<String> winnerNames) {
        String message = "";
        for (String name: winnerNames) {
            message = message + name + ", ";
        }
        message = message.substring(0, message.length() - 2) + WINNER_PHRASE;

        System.out.println(message);
    }
}
