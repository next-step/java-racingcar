package racingcar.view;

import racingcar.participant.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static String printWinners(List<Car> cars) {
        return String.format("%s가 최종 우승했습니다.", cars.stream()
                .sorted((car1, car2) -> car2.getDistance().compareTo(car1.getDistance()))
                .map(Car::print).collect(Collectors.joining(", ")));
    }

    public static String printCarsDistance(List<Car> cars) {
        StringBuilder result = new StringBuilder();
        cars.stream()
                .sorted()
                .map(Car::print).forEach(car -> result.append(car).append("\n"));
        return result.toString();
    }
}
