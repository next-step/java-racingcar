package racingcar.view;

import racingcar.Car;

import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String NEW_LINE = "\n";
    private static final String POSITION_MARK = "-";

    public static void printResultMessage() {
        System.out.println(NEW_LINE + RESULT_MESSAGE);
    }

    public static void printResult(final List<Car> cars) {
        System.out.println();
        cars.forEach(ResultView::printPosition);
    }

    private static void printPosition(final Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(POSITION_MARK);
        }
        System.out.println();
    }
}
