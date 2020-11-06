package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String NEW_LINE = "\n";
    private static final String POSITION_MARK = "-";

    public static void printResultMessage() {
        System.out.println(NEW_LINE + RESULT_MESSAGE);
    }

    public static void printResult(final List<Car> cars) {
        cars.forEach(car -> System.out.println(printPosition(car)));
        System.out.println();
    }

    static String printPosition(final Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append(POSITION_MARK);
        }
        return stringBuilder.toString();
    }
}
