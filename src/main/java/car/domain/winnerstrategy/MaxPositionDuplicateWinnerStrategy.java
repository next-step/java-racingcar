package car.domain.winnerstrategy;

import car.domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class MaxPositionDuplicateWinnerStrategy implements WinnerStrategy {

    @Override
    public List<Car> getWinners(final List<Car> cars) {
        return cars.stream()
            .filter(car -> car.positionIsEqualTo(calculateMaxPosition(cars)))
            .collect(Collectors.toList());
    }

    private static int calculateMaxPosition(final List<Car> cars) {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new IllegalArgumentException("자동차 리스트는 비어있을 수 없습니다."));
    }
}
