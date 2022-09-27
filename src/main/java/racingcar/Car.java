package racingcar;

import racingcar.strategy.MovingStrategy;

public class Car {

    private final Position position;

    public Car() {
        this(0);
    }

    public Car(int position) {
        this.position = new Position(position);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public Position move(MovingStrategy movingStrategy) {
        if (movingStrategy.shouldMove()) {
            position.move();
        }
        return position;
    }
}
