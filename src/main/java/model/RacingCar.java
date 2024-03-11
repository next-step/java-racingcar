package model;

public class RacingCar {

    private static final int MOVE_THRESHOLD = 4;

    private final Location location;
    private final Name name;

    public RacingCar(final Name name) {
        location = new Location(0);
        this.name = name;
    }

    public RacingCar(final Location location, final Name name) {
        this.location = location;
        this.name = name;
    }

    public void move(final int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            location.increase();
        }
    }

    public int getLocationValue() {
        return location.getValue();
    }

    public Name getName() {
        return name;
    }

    public String getNameValue() {
        return name.getName();
    }
}
