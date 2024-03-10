package model;

public class RacingCar {

    private static final int MOVE_THRESHOLD = 4;

    private int location;
    private final Name name;

    public RacingCar(final Name name) {
        this.name = name;
    }

    public void move(final int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }
}
