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

    public Car(String name, int location) {
        this(new Name(name), new Location(location));
    }

    public void move(Generator generator) {
        if (generator.nextValue() >= MINIMUM_MOVE_VALUE) {
            location.next();
        }
    }

    public boolean isFar(Car compare) {
        if (this.location.compareTo(compare.location) > 0) {
            return true;
        }
        return false;
    }

    public Name findCollinearName(Car compare) {
        if (this.location.equals(compare.location)) {
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
