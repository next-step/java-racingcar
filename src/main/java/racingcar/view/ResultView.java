package racingcar.view;

import racingcar.Car;

import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String POSITION_MARK = "-";

    public static void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(POSITION_MARK.repeat(car.position()));
        }
        System.out.println();
    }
}
