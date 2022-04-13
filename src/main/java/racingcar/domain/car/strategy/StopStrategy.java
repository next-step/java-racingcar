package racingcar.domain.car.strategy;

import racingcar.domain.car.Car;

public class StopStrategy implements CarActionStrategy {
    private final CarAction carAction = CarAction.STOP;

    public void act(Car car) {
    }

    public CarAction getCarAction() {
        return carAction;
    }
}
