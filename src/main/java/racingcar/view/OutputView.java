package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    private static final String RACING_RESULT_PROMPT = "실행결과";
    private static final String MOVE_DISTANCE_MARK = "-";
    private static final String LINE_DIVISION = "\n";

    private OutputView() {
        throw new AssertionError();
    }

    public static void printCarRacingResult() {
        System.out.println(RACING_RESULT_PROMPT);
    }

    public static void printCarRacingIntermediateState(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + getDashOnDistanceByCars(car.currentPosition()));
        }
        System.out.print(LINE_DIVISION);
    }

    private static String getDashOnDistanceByCars(int movementDistance) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MOVE_DISTANCE_MARK.repeat(movementDistance));
        return stringBuilder.toString();
    }
}
