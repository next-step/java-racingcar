package racingcar.domain.car;

import racingcar.domain.game.strategy.MoveStrategy;

import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(final MoveStrategy moveStrategy) {
        this.cars.forEach(car -> car.move(moveStrategy));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }
}
