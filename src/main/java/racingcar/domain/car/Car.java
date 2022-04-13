package racingcar.domain.car;

import racingcar.domain.car.strategy.CarActionStrategy;

public class Car {
    private int position = 0;

    public int getPosition() {
        return this.position;
    }

    public void goForward() {
        position++;
    }

    public void act(CarActionStrategy carActionStrategy) {
        carActionStrategy.act(this);
    }
}
