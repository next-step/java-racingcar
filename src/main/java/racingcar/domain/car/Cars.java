package racingcar.domain.car;

import racingcar.domain.game.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String[] carNames) {
        this.cars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void move(final MoveStrategy moveStrategy) {
        this.cars.forEach(car -> car.move(moveStrategy));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public List<String> getWinners() {
        return getCars()
                .stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getCarName)
                .collect(Collectors.toUnmodifiableList());
    }

    private int getMaxPosition() {
        return this.cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException("최대 포지션에 위치한 자동차가 없습니다."));
    }
}
