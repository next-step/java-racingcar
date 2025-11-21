package racingcar.view;

import racingcar.Cars;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_DELIMITER = ", ";
    public static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRoundResult(Cars cars) {
        for (String line : cars.roundResult()) {
            System.out.println(line);
        }
        System.out.println();
    }

    public static void printWinners(Cars cars) {
        System.out.println(String.join(WINNER_DELIMITER, cars.winnerNames()) + WINNER_MESSAGE);
    }
}
