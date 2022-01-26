package racingcar.utils;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class OutputView {

    private static final String MARK = "-";
    private static final String DELIMITER = ", ";

    private OutputView() {
    }

    public static void showResult(List<Car> cars) {
        cars.forEach(OutputView::showCarStatus);
        System.out.println();
    }

    private static void showCarStatus(Car car) {
        String position = createPositionBar(car.position());
        System.out.println(car.getName() + ": " + position);
    }

    private static String createPositionBar(int position) {
        StringBuilder positionBar = new StringBuilder();
        while (position-- > 0) {
            positionBar.append(MARK);
        }
        return positionBar.toString();
    }

    public static void showWinners(List<Car> winners) {
        String winnerNames = createWinnerNames(winners);
        System.out.println("최종 우승자: " + winnerNames);
    }

    private static String createWinnerNames(List<Car> winners) {
        return winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(DELIMITER));
    }
}
