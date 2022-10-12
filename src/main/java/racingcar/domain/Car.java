package racingcar.domain;

public class Car {
    private static final int MINIMUM_MOVE_VALUE = 4;

    private final Name name;
    private final Location location;

    public Car(Name name) {
        this(name, new Location());
    }

    public Car(Name name, Location location) {
        this.name = name;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void move(Generator generator) {
        if (generator.nextValue() >= MINIMUM_MOVE_VALUE) {
            location.next();
        }
    }

    public Name getName() {
        return name;
    }

    public boolean isFar(Car compare) {
        return this.location.isBig(compare.location);
    }

    public Name findCollinearName(Car compare) {
        if (this.location.equals(compare.location)) {
            return name;
        }
        return null;
    }
}
