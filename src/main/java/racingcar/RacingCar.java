package racingcar;

public class RacingCar {

    private int distance;

    private static final int MOVABLE_BOUNDARY_NUMBER = 4;

    public RacingCar() { }

    public void moveOrStop(int randomNumber) {
        if (randomNumber >= MOVABLE_BOUNDARY_NUMBER) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }
}
