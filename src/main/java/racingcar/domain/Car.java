package racingcar.domain;

import racingcar.utils.RandomGenerator;

public class Car {
    private static final int INITIAL_LOCATION = 1;
    private int location;

    private final RandomGenerator randomGenerator = new RandomGenerator();

    public Car() {
        this(INITIAL_LOCATION);
    }

    public Car(int location) {
        this.location = location;
    }

    public int getLocation() {
        return this.location;
    }

    public void move() {
        if(randomGenerator.isMovable()) {
            this.location++;
        }
    }
}
