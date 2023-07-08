package racingcar.car.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.domain.Car;

public final class OutputView {

    public static final String CAR_STATUS_UNIT = "-";
    public static final String CAR_NAME_STATUS_DELIMITER = " : ";
    public static final String CAR_WINNER_JOIN_DELIMITER = ", ";
    public static final char LINE_BREAKER = '\n';

    public void printWinners(final List<Car> winners) {
        System.out.println(formatCarWinners(winners) + "가 최종 우승했습니다.");
    }

    public void printResult(final String result) {
        System.out.println(LINE_BREAKER + "실행 결과");
        System.out.print(result);
    }

    public String formatCars(final List<Car> cars) {
        StringBuilder sb =  new StringBuilder();
        cars.forEach(car -> sb.append(formatCar(car)).append(LINE_BREAKER));
        sb.append(LINE_BREAKER);
        return sb.toString();
    }

    private String formatCarWinners(final List<Car> winners) {
        return winners.stream()
            .map(Car::getNameValue)
            .collect(Collectors.joining(CAR_WINNER_JOIN_DELIMITER));
    }

    private String formatCar(final Car car) {
        return car.getNameValue() + CAR_NAME_STATUS_DELIMITER + CAR_STATUS_UNIT.repeat(car.getPosition());
    }
}
