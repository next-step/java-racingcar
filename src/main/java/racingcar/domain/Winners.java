package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class Winners {

    private List<Car> winners;

    private Winners(List<Car> cars) {
        winners = cars;
    }

    public static Winners findWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return new Winners(cars.stream()
            .filter(car -> car.position() == maxPosition)
            .collect(Collectors.toList()));
    }

    public List<Car> winners() {
        return Collections.unmodifiableList(winners);
    }

    private static int findMaxPosition(List<Car> cars) {
        return cars.stream()
            .mapToInt(Car::position)
            .max()
            .orElse(0);
    }
}
