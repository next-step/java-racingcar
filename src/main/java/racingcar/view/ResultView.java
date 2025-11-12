package racingcar.view;

import racingcar.Car;

import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String POSITION_SEPARATOR = " : ";
    private static final String POSITION_MARK = "-";
    private static final String WINNER_DELIMITER = ",";
    public static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.name() + POSITION_SEPARATOR + POSITION_MARK.repeat(car.position()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(WINNER_DELIMITER, winners) + WINNER_MESSAGE);
    }
}
