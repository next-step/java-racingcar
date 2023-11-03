package racingcar;

import racingcar.strategy.MovingStrategy;

public class Car {

    private final Position position;
    private final MovingStrategy movingStrategy;

    public Car(MovingStrategy movingStrategy) {
        this.position = new Position();
        this.movingStrategy = movingStrategy;
    }

    public int getPosition() {
        return this.position.getNumber();
    }

    public void move() {
        this.position.move(this.movingStrategy.movingCondition());
    }
}
