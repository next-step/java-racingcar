package racinggame.domain;

public class Car {

    private Location location;

    public Car() {
        this(Location.START_LOCATION);
    }

    public Car(int location) {
        this.location = new Location(location);
    }

    public void move(State state) {
        if (state == State.MOVE) {
            location.move();
        }
    }

    public Location getLocation() {
        return location;
    }
}
