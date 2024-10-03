package step3.view;

import java.util.List;
import step3.model.Car;
import step3.model.Cars;

public class OutputView {
    private static final String DELIMITER = ", ";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String MOVEMENT = "-";
    private static final String COLON = " : ";
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";

    public static void printRacingResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRacingProgress(final Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + COLON + MOVEMENT.repeat(car.getMovement()));
        }
        System.out.println();
    }

    public static void printRacingWinners(final List<String> winners) {
        System.out.printf(WINNER_MESSAGE, String.join(DELIMITER, winners));
    }
}
