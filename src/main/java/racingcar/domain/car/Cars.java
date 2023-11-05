package racingcar.domain.car;

import racingcar.domain.game.strategy.MoveStrategy;

import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void move(final MoveStrategy moveStrategy) {
        this.carList.forEach(car -> car.move(moveStrategy));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.carList);
    }
}
