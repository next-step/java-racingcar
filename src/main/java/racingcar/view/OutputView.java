package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public static final String MOVE_DISTANCE_MARK = "-";
    public static final String LINE_DIVISION = "\n";

    public static void printCarRacingIntermediateState(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(getDashOnDistanceByCars(car.getDistanceTraveled()));
        }
        System.out.print(LINE_DIVISION);
    }

    public static String getDashOnDistanceByCars(int movementDistance) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MOVE_DISTANCE_MARK.repeat(movementDistance));
        return stringBuilder.toString();
    }
}
