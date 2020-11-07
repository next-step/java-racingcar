package step3.worker.domain.strategy;

import step3.worker.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class SelectFarthestDistanceWinnerStrategy implements SelectWinnerStrategy{
    @Override
    public List<Car> select(final List<Car> cars) {
        final int farthestDistance = findFarthestDistance(cars);
        return cars.stream()
                .filter(car -> car.isPositionEqual(farthestDistance))
                .collect(Collectors.toList());
    }

    private int findFarthestDistance(final List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }
}
