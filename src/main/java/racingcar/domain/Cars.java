package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> elements;

    public Cars(List<Car> members) {
        validateNotEmpty(members);
        this.elements = new ArrayList<>(members);
    }

    public static Cars from(List<String> carNames) {
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(carList);
    }

    private void validateNotEmpty(List<Car> cars) {
        if (cars == null || cars.isEmpty() || cars.stream().anyMatch(Objects::isNull))
            throw new IllegalArgumentException("there should be one or more cars. can not be null or empty");
    }

    public List<CarState> move(MoveStrategy moveStrategy) {
        return elements.stream()
                .map(car -> car.move(moveStrategy))
                .collect(Collectors.toList());
    }

    public List<CarState> findWinners() {
        int winnerPosition = findWinnerPosition();
        return elements.stream()
                .filter(car -> car.isPositionSame(winnerPosition))
                .map(Car::getCarState)
                .collect(Collectors.toList());
    }

    private int findWinnerPosition() {
        int winnerPosition = 0;
        for(Car car : elements) {
            winnerPosition = car.max(winnerPosition);
        }
        return winnerPosition;
    }
}
