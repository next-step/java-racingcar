package racingcar.domain;

import racingcar.utils.RandomGenerator;

import java.util.Objects;

public class Car {
    private static final int INITIAL_LOCATION = 1;
    private final String name;
    private int location;

    public Car(String name) {
        this(name, INITIAL_LOCATION);
    }

    public Car(String name, int location) {
        this.name = name;
        this.location = location;

    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    public void move(MoveStrategy moveStrategy) {
        if(moveStrategy.isMovable()) {
            this.location++;
        }
    }
}
