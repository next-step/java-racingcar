package racingcar.moverule;

import racingcar.car.Car;

@FunctionalInterface
public interface MoveRule {
    void move(Car car);
}
