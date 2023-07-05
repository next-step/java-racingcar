package racingcar.car.domain.winnerstrategy;

import racingcar.car.domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class MaxPositionDuplicateWinnerStrategy implements WinnerStrategy {

    @Override
    public List<Car> getWinners(List<Car> cars) {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new IllegalArgumentException("자동차 리스트는 비어있을 수 없습니다."));

        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .collect(Collectors.toList());
    }
}
