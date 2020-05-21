package me.daeho.step5.view;

import me.daeho.step5.domain.Car;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private final static String CAR_PATH = "-";
    private final static String NAME_DELIMITER = " : ";
    private final static String WINNER_DELIMITER = ", ";

    private ResultView() {
    }

    public static ResultView create() {
        return new ResultView();
    }

    public void showResult(Collection<Car> cars) {
        cars.forEach(v -> showPathByCarName(v.getName(), v.getCurrentPosition()));
        System.out.println();
    }

    public void showWinners(Collection<Car> cars) {
        System.out.println(cars.stream().map(Car::getName).collect(Collectors.joining(WINNER_DELIMITER)) + "가 최종 우승했습니다.");
        System.out.println();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    private void showPathByCarName(String name, int carPosition) {
        final StringBuilder sb = new StringBuilder(name).append(NAME_DELIMITER);
        IntStream.range(0, carPosition).forEach(pos -> sb.append(CAR_PATH));
        System.out.println(sb.toString());
    }
}
