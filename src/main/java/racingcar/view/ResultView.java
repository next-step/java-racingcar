package racingcar.view;

import racingcar.Car;
import racingcar.Cars;
import racingcar.Winners;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String MOVED_EXPRESSION = "-";

    private ResultView() {
        throw new IllegalStateException("Utility class.");
    }

    public static void printCarsPosition(Cars cars) {
        cars.getCars().forEach(car -> print(car.getName(), car.getDistance()));
        System.out.println();
    }

    private static void print(String name, int distance) {
        StringBuilder builder = new StringBuilder();
        builder.append(MOVED_EXPRESSION.repeat(Math.max(0, distance)));
        System.out.println(name + " : " + builder.toString());
    }

    public static void printWinner(Cars cars) {
        System.out.println(String.join(", ", getWinners(cars)) + "가 최종 우승했습니다.");
    }

    private static List<String> getWinners(Cars cars) {
        return Winners
                .findWinners(cars)
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
