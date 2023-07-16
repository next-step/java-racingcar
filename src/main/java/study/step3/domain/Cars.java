package study.step3.domain;

import study.step3.domain.strategy.MoveStrategy;
import study.step3.domain.strategy.RandomMoveStrategy;

public class Cars {
    private final Car[] cars;
    private final MoveStrategy moveStrategy;

    public Cars(Car[] cars) {
        this.cars = cars;
        this.moveStrategy = new RandomMoveStrategy();
    }

    public void race() {
        for (Car car : cars) {
            if (moveStrategy.canMove()) {
                car.move();
            }
        }
    }
}
