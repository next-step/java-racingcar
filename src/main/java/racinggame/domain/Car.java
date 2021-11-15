package racinggame.domain;

public class Car {

    private Name name;
    private Location location;

    public Car(Name name) {
        this(name, Location.START_LOCATION);
    }

    public Car(Name name, int location) {
        this.name = name;
        this.location = new Location(location);
    }

    public void move(StateGenerator state) {
        if (state.getState() == State.MOVE) {
            location.move();
        }
    }

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }
}
