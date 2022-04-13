package racingcar.domain.car.strategy;

import racingcar.domain.car.Car;

public interface CarActionStrategy {
    void act(Car car);

    CarAction getCarAction();
}
