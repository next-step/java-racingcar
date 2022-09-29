package racingcar;

import racingcar.strategy.MovingStrategy;

public class Car {

    private int position;

    public Car() {
        this.position = 0;
    }

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public int move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            return ++this.position;
        }
        return position;
    }
}
