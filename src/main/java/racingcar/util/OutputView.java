package racingcar.util;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String DISTINCTION_EACH_WINNER_DELIMITER = ",";
    private static final String UNIT_OF_DISTANCE = "-";
    private static final String ANNOUNCEMENT_RACING_RESULT = "실행 결과";
    private static final String ANNOUNCEMENT_WINNER = "가 최종 우승했습니다.";
    private static final String DISTINCTION_CAR_AND_DISTANCE = " : ";

    public static void printCarTraceUntilNow(Car car) {
        System.out.print(car.getName() + DISTINCTION_CAR_AND_DISTANCE);
        for (int i = 0; i < car.showNowPosition(); i++) {
            System.out.print(UNIT_OF_DISTANCE);
        }
        System.out.println();
    }

    public static void resultIntro() {
        System.out.println();
        System.out.println(ANNOUNCEMENT_RACING_RESULT);
    }

    public static void printWinnerNames(List<String> winnerNames) {
        System.out.print(String.join(DISTINCTION_EACH_WINNER_DELIMITER, winnerNames));
        System.out.println(ANNOUNCEMENT_WINNER);
        System.out.println();
    }

    public static void printInput(String input) {
        System.out.print(input);
    }

}
