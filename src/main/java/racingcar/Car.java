package racingcar;

public class Car {
    private static final int INITIAL_DISTANCE = 0;
    private static final int MOVING_STANDARD = 4;
    private int distance;

    public Car() {
        this.distance = INITIAL_DISTANCE;
    }

    public Car(int distance) {
        this.distance = distance;
    }

    public void move(int randomNumber) {
        if(randomNumber >= MOVING_STANDARD) {
            distance += 1;
        }
    }

    public int getDistance() {
        return distance;
    }
}
