package racinggame.domain;

import java.util.List;

public class Car {

    private static final int DEFAULT_LOCATION = 0;

    private final CarName name;
    private int location;

    public Car(final String name) {
        this(name, DEFAULT_LOCATION);
    }

    public Car(final String name, int location) {
        this.name = new CarName(name);
        this.location = location;
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name.get();
    }

    public void moveForward() {
        this.location++;
    }
}
