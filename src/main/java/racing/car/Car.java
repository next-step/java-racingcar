package racing.car;

public class Car {
    private Location location;
    private int moveCount;

    public Car() {
        this.location = Location.EMPTY;
        this.moveCount = 0;
    }

    public Location getLocation() {
        return location;
    }

    public boolean isMoved() {
        return moveCount > 0;
    }

    public void move(Distance distance) {
        ++moveCount;
        this.location = location.add(distance);
    }
}
