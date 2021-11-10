package racinggame.domain;

public class Car {


    private Location location;

    public Car() {
        this.location = new Location();
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
