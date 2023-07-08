package racing.io;

import java.util.List;
import racing.model.Car;
import racing.model.Cars;

public class GameViewer {

    public static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String RESULT_OUTPUT_GUIDE = "실행 결과";
    private static final String WINNER_OUTPUT_SUFFIX = "가 최종 우승했습니다.";
    private static final String DEFAULT_PRINT_DELIMITER = ", ";

    public void printBeforeRacing(final Cars cars) {
        System.out.println(RESULT_OUTPUT_GUIDE);
        printCars(cars);
    }

    public void printCars(final Cars cars) {
        final StringBuilder builder = new StringBuilder();
        cars.getCars()
            .stream()
            .map(this::carStatus)
            .forEach(carStatus -> builder.append(carStatus).append(LINE_SEPARATOR));
        System.out.println(builder);
    }

    public void printWinners(final List<String> winnerNames) {
        final String result = String.join(DEFAULT_PRINT_DELIMITER, winnerNames);
        System.out.println(result + WINNER_OUTPUT_SUFFIX);
    }

    private String carStatus(final Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }
}
