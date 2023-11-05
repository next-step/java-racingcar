package racingcar.domain;

import racingcar.strategy.MoveStrategy;

import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void move(MoveStrategy moveStrategy) {
        this.carList.forEach(car -> car.move(moveStrategy));
    }

    public List<Car> getCars() {
        return this.carList;
    }
}
