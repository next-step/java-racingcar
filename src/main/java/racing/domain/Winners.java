package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> winners;

    public Winners(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("Input이 null입니다.");
        }
        this.winners = new ArrayList<>();
        Position maxPosition = getMaxPosition(cars);
        findWinners(cars, maxPosition);
    }

    private static Position getMaxPosition(List<Car> cars) {
        List<Position> positions = cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());

        return Collections.max(positions);
    }

    private void findWinners(List<Car> cars, Position maxPosition) {
        for (Car car : cars) {
            addWinner(maxPosition, car);
        }
    }

    private void addWinner(Position maxPosition, Car car) {
        if (Objects.equals(car.getPosition(), maxPosition)) {
            winners.add(car);
        }
    }

    public List<Name> toNames() {
        List<Name> names = new ArrayList<>();
        for (Car winner : winners) {
            names.add(winner.getName());
        }
        return names;
    }
}