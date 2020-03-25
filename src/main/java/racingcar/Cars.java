package racingcar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparingInt;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getWinners() {
        Car winner = cars.stream()
                .sorted(comparingInt(Car::getPosition).reversed())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("우승자가 없습니다"));

        return Arrays.asList(winner.getName());
    }
}
