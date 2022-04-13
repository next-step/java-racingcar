package racingcar.domain.car.strategy;

import racingcar.domain.car.Car;

public class MoveStrategy implements CarActionStrategy {
    private final CarAction carAction = CarAction.GO_FORWARD;

    public void act(Car car) {
        car.goForward();
    }

    public CarAction getCarAction() {
        return carAction;
    }
}
