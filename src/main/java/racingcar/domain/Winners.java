package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private static final Position MIN_POSITION = new Position();

    private final List<Car> winners;

    public Winners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        winners = cars.stream()
                .filter(car -> car.sameOf(maxPosition))
                .collect(Collectors.toList());
    }

    public List<String> getNames() {
        return winners.stream()
                .map(Car::name)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::position)
                .max()
                .orElse(MIN_POSITION.value());
    }
}
