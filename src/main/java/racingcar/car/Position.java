package racingcar.car;

public class Position {

    private int currentLocation;

    public Position(int currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Position add() {
        return new Position(currentLocation++);
    }

    public int getCurrentLocation() {
        return currentLocation;
    }
}
