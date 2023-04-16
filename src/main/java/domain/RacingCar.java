package domain;

public class RacingCar {

    private int distance;

    private static final int ONE_TIME_DISTANCE = 1;

    public RacingCar() {
    }

    public void moveOrStop(boolean coin) {
        if (coin) {
            this.distance += ONE_TIME_DISTANCE;
        }
    }

    public int getDistance() {
        return distance;
    }
}
