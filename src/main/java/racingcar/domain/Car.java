package racingcar.domain;

import racingcar.generator.Generator;

public class Car {
    private static final int MINIMUM_MOVE_VALUE = 4;

    private final Name name;
    private final Location location;

    public Car(Name name, Location location) {
        this.name = name;
        this.location = location;
    }

    public Car(String name) {
        this(new Name(name), new Location());
    }

    public void move(Generator generator) {
        if (generator.nextValue() >= MINIMUM_MOVE_VALUE) {
            location.next();
        }
    }

    public Location findFar(Location max) {
        if (this.location.compareTo(max) > 0) {
            return this.location;
        }
        return max;
    }

    public Name findCollinearName(Location compare) {
        if (this.location.equals(compare)) {
            return name;
        }
        return null;
    }

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }
}
