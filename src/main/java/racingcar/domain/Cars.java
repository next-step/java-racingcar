package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(MovingStrategy movingStrategy) {
        cars.forEach(c -> c.move(movingStrategy));
    }

    public CarNames getWinnerNames() {
        Position winnerPosition = getMaxPosition();
        return new CarNames(cars.stream()
                .filter(c -> c.isWinner(winnerPosition))
                .map(Car::getName)
                .collect(Collectors.toList()));
    }정

    private Position getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Position::compareTo)
                .orElse(new Position());
    }

    public List<CarResponse> getCars() {
        return cars.stream()
                .map(CarResponse::of)
                .collect(Collectors.toList());
    }
}
