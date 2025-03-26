package racingcar.domain;

import racingcar.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateNotEmpty(cars);
        validateElementNotNull(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validateNotEmpty(List<Car> cars) {
        if (cars == null || cars.isEmpty())
            throw new IllegalArgumentException("자동차가 없습니다.");
    }

    private void validateElementNotNull(List<Car> cars) {
        boolean hasNullElement = cars.stream().anyMatch(Objects::isNull);
        if (hasNullElement)
            throw new IllegalArgumentException("자동차가 null입니다.");
    }

    public List<CarState> move(NumberGenerator numberGenerator) {
        return cars.stream()
                .map(car -> car.move(numberGenerator))
                .collect(Collectors.toList());
    }

    public List<Car> findWinners() {
        int winnerPosition = findWinnerPosition();
        return cars.stream()
                .filter(car -> car.isPositionSame(winnerPosition))
                .collect(Collectors.toList());
    }

    private int findWinnerPosition() {
        int winnerPosition = 0;
        for(Car car : cars) {
            winnerPosition = car.max(winnerPosition);
        }
        return winnerPosition;
    }
}
