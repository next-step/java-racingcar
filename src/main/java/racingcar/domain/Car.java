package racingcar.domain;

public class Car implements Comparable<Car> {
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

    void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
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
