package racingcar;

import racingcar.movablestrategy.MovableStrategy;
import racingcar.movablestrategy.RandomStrategy;

public class Car {
    public static final int INITIAL_POSITION = 0;
    public static final int MOVE_DISTANCE = 1;
    public static final int MOVE_CONDITION = 4;
    private int currentPosition = 0;
    private MovableStrategy movableStrategy;

    public Car() {
        this(new RandomStrategy(MOVE_CONDITION, 10));
    }

    public Car(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
    }

    public void move() {
        if (movableStrategy.movable()) {
            currentPosition += MOVE_DISTANCE;
        }
    }

    public boolean samePosition(int position) {
        return currentPosition == position;
    }

    public int currentPosition() {
        return currentPosition;
    };
}
