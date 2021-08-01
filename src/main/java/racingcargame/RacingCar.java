package racingcargame;

public class RacingCar {
    private static final int MOVING_VALUE = 4;

    private int distance = 0;

    public int tryToMove(int randomValue) {
        if (randomValue >= MOVING_VALUE) {
            return this.move();
        }
        return this.stop();
    }

    private int move() {
        return distance += 1;
    }

    private int stop() {
        return distance += 0;
    }

    public int getDistance() {
        return distance;
    }
}