package study.carracing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    public List<String> pickWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);

        return cars.stream()
                .filter(car -> car.isSame(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.compareToMaxPosition(maxPosition);
        }

        return maxPosition;
    }
}
