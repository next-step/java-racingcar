package racingcar.domain;

import racingcar.behavior.MovingStrategy;

public class Car {
    static final int DEFAULT_DISTANCE = 0;

    private int position;


    private String carName;

    public Car(String carName) {
        this.position = DEFAULT_DISTANCE;
        this.carName = carName;
    }

    public void move(final MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getCarName() {
        return this.carName;
    }
}
