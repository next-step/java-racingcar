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

    public String getName() {
        return name.getName();
    }

    public int getLocation() {
        return location.getLocation();
    }
}
