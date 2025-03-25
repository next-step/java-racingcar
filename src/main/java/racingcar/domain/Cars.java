package racingcar.domain;

import racingcar.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public List<Integer> move(NumberGenerator numberGenerator) {
        return cars.stream()
                .map(car -> car.move(numberGenerator))
                .collect(Collectors.toList());
    }
}
