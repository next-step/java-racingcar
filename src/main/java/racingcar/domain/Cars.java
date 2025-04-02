package racingcar.domain;

import racingcar.dto.CarDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> elements;

    public Cars(List<Car> members) {
        validateNotEmpty(members);
        validateElementNotNull(members);
        this.elements = new ArrayList<>(members);
    }

    public static Cars from(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private void validateNotEmpty(List<Car> cars) {
        if (cars == null || cars.isEmpty())
            throw new IllegalArgumentException("car collection should not be null or empty.");
    }

    private void validateElementNotNull(List<Car> members) {
        if (members.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("car should not be null.");
        }
    }

    public List<CarDto> moveAll(MoveStrategy moveStrategy) {
        elements.forEach(element -> element.move(moveStrategy));

        return elements.stream()
                .map(Car::toDto)
                .collect(Collectors.toList());
    }

    public List<CarDto> findWinners() {
        Car winner = findWinner();
        return elements.stream()
                .filter(car -> car.isSamePositionWith(winner))
                .map(Car::toDto)
                .collect(Collectors.toList());
    }

    private Car findWinner() {
        return elements.stream()
                .reduce((car1, car2) -> car1.isAheadOf(car2)? car1 : car2)
                .orElseThrow(() -> new IllegalStateException("can not find winner car"));
    }


}
