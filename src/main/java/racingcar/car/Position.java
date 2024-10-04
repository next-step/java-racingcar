package racingcar.car;

public class Position {

    private final int currentLocation;

    public Position(int currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Position add() {
        return new Position(currentLocation + 1);
    }

    public int getCurrentLocation() {
        return currentLocation;
    }
}
