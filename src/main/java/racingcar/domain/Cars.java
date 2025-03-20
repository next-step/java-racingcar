package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;
import racingcar.util.Pair;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;
    private List<Car> winnerCars;

    private Cars(List<Car> cars) {
        this.cars = cars;
        this.winnerCars = null;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public List<Name> getWinnerCarNames() {
        return getWinnerCars().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Car> getWinnerCars() {
        if (this.winnerCars != null) {
            return this.winnerCars;
        }
        Position maxPosition = getMaxPosition(this.cars);
        this.winnerCars = this.cars.stream()
                .filter(car -> car.getPosition().compareTo(maxPosition) == 0)
                .collect(Collectors.toList());
        return this.winnerCars;
    }

    private Position getMaxPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Position::compareTo)
                .orElseThrow(IllegalStateException::new);
    }

    public List<Pair<Name, Position>> getCarsNameAndPosition() {
        return cars.stream()
                .map(car -> new Pair<>(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    public void moveAll(MoveStrategy moveStrategy) {
        if (winnerCars != null) {
            throw new IllegalStateException("우승자가 이미 결정되었습니다.");
        }
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }
}
