package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(final List<Car> cars) {
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void run() {
        cars.stream().forEach(Car::move);
    }

    public List<Car> getWinners() {
        return cars.stream()
                .filter(it -> it.getPosition() == getBestPosition())
                .collect(Collectors.toList());
    }

    private int getBestPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElse(0);
    }
}
