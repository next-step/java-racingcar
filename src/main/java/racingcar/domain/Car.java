package racingcar.domain;

public class Car {
    public static final int MINIMUM_MOVE_VALUE = 4;

    private final Name name;
    private Location location;

    public Car(Name name) {
        this.name = name;
        this.location = new Location();
    }

    public Location getLocation() {
        return location;
    }

    public void move(Generator generator) {
        if (generator.nextValue() >= MINIMUM_MOVE_VALUE) {
            location = location.next();
        }
    }

    public Name getName() {
        return name;
    }
}
