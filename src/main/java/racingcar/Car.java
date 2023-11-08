package racingcar;

import racingcar.movablestrategy.MovableStrategy;

public class Car {
    public static final int MOVE_DISTANCE = 1;
    private int currentPosition = 0;
    private String racerName;
    private MovableStrategy movableStrategy;

    public Car() {
        this("noName",() -> true);
    }

    public Car(String racerName) {
        this(racerName, () -> true);
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
