package step3.view;

import java.util.List;
import step3.model.Car;
import step3.model.Cars;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String MOVEMENT = "-";

    public static void printRacingResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRacingProgress(final Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(MOVEMENT.repeat(car.getMoveCount()));
        }
        System.out.println();
    }
}
