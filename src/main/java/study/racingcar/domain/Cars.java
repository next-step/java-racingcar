package study.racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getResult() {
        return cars;
    }

    public void moveAll(MovingStrategy movingStrategy) {
        cars.forEach(car -> car.move(movingStrategy));
    }

    public List<Car> findWinners() {
        Car winner = findFirstWinner();
        Position winnerPosition = winner.getPosition();
        return filterByPosition(winnerPosition);
    }

    private List<Car> filterByPosition(Position winnerPosition) {
        return cars.stream()
            .filter(car -> car.matchPosition(winnerPosition))
            .collect(Collectors.toList());
    }

    private Car findFirstWinner() {
        return cars.stream()
            .max(Car::compare)
            .orElseThrow(IllegalArgumentException::new);
    }
}
