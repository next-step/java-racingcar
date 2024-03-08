package model;

public class RacingCar {

    private static final int MOVE_THRESHOLD = 4;

    private int location;

    public void move(final int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }
}
