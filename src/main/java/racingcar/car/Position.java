package racingcar.car;

public class Position {

    public static final int INITIAL_LOCATION = 0;
    private int currentLocation;

    public Position() {
        this.currentLocation = INITIAL_LOCATION;
    }

    public void add() {
        currentLocation++;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }
}
