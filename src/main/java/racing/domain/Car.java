package racing.domain;

import racing.behavior.CarMovable;
import racing.behavior.Movable;

public class Car {
    private static final int INITIAL_LOCATION = 0;

    private int location;
    private final Movable movable;

    public Car(final int location, final Movable movable) {
        this.location = location;
        this.movable = movable;
    }

    public static Car of(final CarMovable movable) {
        return new Car(INITIAL_LOCATION, movable);
    }

    public void move() {
        if (movable.move()) {
            this.location++;
        }
    }

    public int getLocation() {
        return location;
    }
}
