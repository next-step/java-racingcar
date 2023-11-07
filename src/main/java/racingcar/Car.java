package racingcar;

import racingcar.movablestrategy.MovableStrategy;
import racingcar.movablestrategy.RandomStrategy;

public class Car {
    public static final int MOVE_DISTANCE = 1;
    public static final int MOVE_CONDITION = 4;
    private int currentPosition = 0;
    private String racerName;
    private MovableStrategy movableStrategy;

    public Car() {
        this("noName",new RandomStrategy(MOVE_CONDITION, 10));
    }

    public Car(String racerName) {
        this(racerName, new RandomStrategy(MOVE_CONDITION, 10));
    }

    public Car(MovableStrategy movableStrategy) {
        this("noName", movableStrategy);
    }

    public Car(String racerName, MovableStrategy movableStrategy) {
        this.racerName = racerName;
        this.movableStrategy = movableStrategy;
    }

    public void move() {
        if (movableStrategy.movable()) {
            currentPosition += MOVE_DISTANCE;
        }
    }
    public int currentPosition() {
        return currentPosition;
    };

    public String racerName() {
        return racerName;
    };
}
