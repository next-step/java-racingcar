package study.step5.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        return getWinners(getMaxPosition());
    }

    private List<Car> getWinners(Position maxPosition) {
        return cars.stream()
            .filter(car -> maxPosition.equals(car.getPosition()))
            .collect(Collectors.toList());
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position(0);
        for(Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }
}
