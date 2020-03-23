package racingcar.view;

import racingcar.util.Delimeters;

import java.util.List;

public class ResultView {
    private static final String WINNER_ALARM_MESSAGE = "가 우승했습니다.";

    public static void nextLine() {
        System.out.println();
    }

    public static void printPosition(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.printf(Delimeters.DASH);
        }
        nextLine();
    }

    public static void printCarName(String carName) {
        System.out.printf(carName + Delimeters.COLON);
    }

    public static void printWinnerName(List<String> winners) {
        System.out.println(String.join(Delimeters.COMMA, winners) + WINNER_ALARM_MESSAGE);
    }
}
