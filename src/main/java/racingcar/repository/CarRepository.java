package racingcar.repository;

import racingcar.domain.Car;
import racingcar.domain.Name;
import racingcar.domain.Position;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.RandomNumberMoveStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {
    private final List<Car> cars;
    private final MoveStrategy randomNumberMoveStrategy = new RandomNumberMoveStrategy();

    public CarRepository(List<Car> cars) {
        this.cars = cars;
    }

    public void save(Car car) {
        cars.add(car);
    }

    public List<Car> findAll() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> findWinnersByMaxPosition(Position maxPosition) {
        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList());
    }

    public Car findByName(Name name) {
        return cars.stream()
                .filter(car -> name.equals(car.getName()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름을 가진 자동차가 없습니다."));
    }

    public Position findMaxPosition() {
        Position maxPosition = new Position(0);

        for (Car car : cars) {
            maxPosition = compareToGetMaxPosition(maxPosition, car);
        }

        return maxPosition;
    }

    public void updateCarsPosition() {
        cars.forEach(car -> car.move(randomNumberMoveStrategy));
    }

    private Position compareToGetMaxPosition(Position maxPosition, Car car) {
        if (car.hasBiggerPositionThan(maxPosition)) {
            maxPosition = car.getPosition();
        }
        return maxPosition;
    }
}
