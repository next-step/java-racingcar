package racingcar.model;

import racingcar.Car;
import racingcar.Cars;

import java.util.stream.Collectors;

public class ResultView {
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String BAR = "-";
    private static final String RACING_PRINT_FORMAT = "{carName}: {position}";
    private static final String WINNERS_PRINT_FORMAT = "{winners}가 최종 우승했습니다.";
    private static final String WINNERS_DELIMITER = ", ";

    public static void printStartComment() {
        System.out.println(EXECUTION_RESULT);
    }

    public static void printRacing(Cars cars) {
        cars.cars()
                .forEach(car -> System.out.println(RACING_PRINT_FORMAT
                        .replace("{carName}", car.name())
                        .replace("{position}", BAR.repeat(car.currentPosition()))));
        System.out.println();
    }

    public static void printWinners(Cars cars) {
        String winners = cars.winners().stream()
                .map(Car::name)
                .collect(Collectors.joining(WINNERS_DELIMITER));

        System.out.println(WINNERS_PRINT_FORMAT.replace("{winners}", winners));
    }
}
