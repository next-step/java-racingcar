package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private static final int MIN_POSITION = 0;

    private final List<Car> winners;

    public Winners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        winners = cars.stream()
                .filter(car -> car.position() == maxPosition)
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
                .orElse(MIN_POSITION);
    }
}
