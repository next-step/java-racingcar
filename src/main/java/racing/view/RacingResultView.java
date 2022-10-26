package racing.view;

import racing.domain.Car;

import java.util.List;

public class RacingResultView {
    public static final String RESULT_MESSAGE = "실행결과";
    public static final String RACING_RESULT_SIGN = "-";

    public static void makeRacingResult(int gameCount, List<Car> carList) {
        for (int i = 0; i < gameCount; i++) {
        }

        System.out.println();
    }

    public static void printResultMessage() {
        System.out.print(RESULT_MESSAGE);
    }

    public static void printResult(int moveCount) {
        System.out.println();
        for (int i = 0; i < moveCount; i++) {
            System.out.print(RACING_RESULT_SIGN);
        }
    }
}
