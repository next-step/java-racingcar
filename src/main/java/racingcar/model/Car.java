package racingcar.model;

public class Car {
    private static final int MOVE_STANDARD = 4;
    private static final int MOVE_DISTANCE = 1;

    private final String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    private int distance = 0;

    public int getDistance() {
        return this.distance;
    }

    public String getCarName() { return this.carName; }

    public void move(int movableNumber) {
        if (movableNumber >= MOVE_STANDARD) {
            distance += MOVE_DISTANCE;
        }
    }
}
