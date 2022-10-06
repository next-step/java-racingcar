package racingcar.domain;

public class Car {
    public static final int MINIMUM_MOVE_VALUE = 4;

    private final Name name;
    private Location location;

    public Car(Name name) {
        this(name, new Location());
    }

    public Car(String name, int location) {
        this(new Name(name), new Location(location));
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
            location = location.next();
        }
    }

    public Name getName() {
        return name;
    }

    public boolean isFar(Car compare) {
        return this.location.isBig(compare.location);
    }

    public boolean isCollinear(Car compare) {
        return this.location.equals(compare.location);
    }
}
