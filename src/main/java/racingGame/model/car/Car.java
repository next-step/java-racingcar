package racingGame.model.car;

import racingGame.model.strategy.MovementStrategy;

public class Car {

    private int position;

    public Car() {
        this(0);
    }

    public Car(int position) {
        this.position = position;
    }

    public Car clone() {
        return new Car(this.getPosition());
    }

    public int getPosition() {
        return this.position;
    }

    public void move(MovementStrategy strategy) {
        if (strategy.isMovable()) {
            this.position++;
        }
    }
}
