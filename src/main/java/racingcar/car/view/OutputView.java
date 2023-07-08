package racingcar.car.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.domain.Car;

public final class OutputView {

    public static final String CAR_STATUS_UNIT = "-";
    public static final String CAR_NAME_STATUS_DELIMITER = " : ";
    public static final String CAR_WINNER_JOIN_DELIMITER = ", ";
    public static final char LINE_BREAKER = '\n';

    private OutputView() {
    }

    public static void printResult(final List<Car> result) {
        System.out.println("실행 결과");
        System.out.println(formatCarWinners(result) + "가 최종 우승했습니다.");
    }

    public static void printStatus(List<Car> carState) {
        carState.forEach(state -> System.out.println(formatCar(state)));
        System.out.print(LINE_BREAKER);
    }

    private static String formatCarWinners(final List<Car> winners) {
        return winners.stream()
            .map(Car::getNameValue)
            .collect(Collectors.joining(CAR_WINNER_JOIN_DELIMITER));
    }

    private static String formatCar(final Car car) {
        return car.getNameValue() + CAR_NAME_STATUS_DELIMITER +
            CAR_STATUS_UNIT.repeat(car.getPosition());
    }
}
