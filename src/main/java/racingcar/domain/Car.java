package racingcar.domain;

public class Car implements Comparable<Car> {
    static final int CRITERION_FOR_MOVING = 4;

    private Location location;
    private Name name;

    Car(String name) {
        this(name, 0);
    }

    Car(String name, int location) {
        this.name = new Name(name);
        this.location = new Location(location);
    }

    Car() {
        this("Unknown");
    }

    public int getLocation() {
        return location.getLocation();
    }

    void goForward() {
        location = location.goForward();
    }

    boolean isAbleToMove(int value) throws IllegalArgumentException {
        if (value < 0 || value > 9) {
            throw new IllegalArgumentException("invalid argument for isAbleToMove : " + value);
        }

        return value >= CRITERION_FOR_MOVING;
    }

    void move(int value) {
        if (isAbleToMove(value)) {
            goForward();
        }
    }

    public String getNameInString() {
        return this.name.toString();
    }

    @Override
    public int compareTo(Car o1) {
        return location.compareTo(o1.location);
    }

    public String getCarStateInString() {
        return name.toString() + " : " + location.toString();
    }

    public boolean equals(Object o) {
        if (o instanceof Car) {
            return name.equals(((Car) o).name) &&
                    location.equals(((Car) o).location);
        }

        return false;
    }
}
