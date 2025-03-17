package racingcar.domain;

import racingcar.strategy.MovingStrategy;
import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void moveAll(MovingStrategy strategy) {
        cars.forEach(car -> car.move(strategy));
    }

    public List<Car> getCurrentStatus() {
        return Collections.unmodifiableList(cars);
    }
}
