package carracing.domain;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private Location location;
    private final Name name;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, int location) {
        this(new Name(name), new Location(location));
    }

    public Car(final Name name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name.getName();
    }

    public int getLocation() {
        return location.getLocation();
    }

    public boolean canMove(int number) {
        if (number >= MOVE_CONDITION) {
            return true;
        }
        return false;
    }

    public void move() {
        location.increase();
    }

    public boolean isWinner(int winnerLocation) {
        return location.isSame(winnerLocation);
    }
}
