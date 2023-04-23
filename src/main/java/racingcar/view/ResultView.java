package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class ResultView {

    private static final String MESSAGE_EXECUTE_RESULT = "실행결과";
    public static final String MESSAGE_WINNER_ANNOUNCEMENT = "%s가 최종 우승했습니다.";

    public static void printResultHeader() {
        System.out.println(MESSAGE_EXECUTE_RESULT);
    }

    public static void printCarsResult(Cars cars) {
        System.out.println(cars.toString());
    }
    public static void printWinners(Cars winners) {
        System.out.printf(MESSAGE_WINNER_ANNOUNCEMENT, winners.toStringNames());
    }
}
