package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    public List<String> findWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return getWinners(maxPosition, cars);
    }

    private int getMaxPosition(List<Car>  cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.maxPosition(maxPosition);
        }
        return maxPosition;
    }

    private List<String> getWinners(int maxPosition, List<Car> cars) {
        return cars.stream()
                .filter(car -> car.matchPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
