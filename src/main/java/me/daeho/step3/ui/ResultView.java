package me.daeho.step3.ui;

import me.daeho.step3.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private final static String CAR_PATH = "-";
    private final static String NAME_DELIMITER = " : ";
    private final static String WINNER_DELIMITER = ", ";

    public static void showResult(List<Car> cars) {
        cars.forEach(v -> showPathByCarName(v.getName(), v.getCurrentPosition()));
        System.out.println();
    }

    public static void showWinners(List<Car> cars) {
        System.out.println(cars.stream().map(Car::getName).collect(Collectors.joining(WINNER_DELIMITER)) + "가 최종 우승했습니다.");
        System.out.println();
    }

    private static void showPathByCarName(String name, int carPosition) {
        final StringBuilder sb = new StringBuilder(name).append(NAME_DELIMITER);
        IntStream.range(0, carPosition).forEach(pos -> sb.append(CAR_PATH));
        System.out.println(sb.toString());
    }
}
