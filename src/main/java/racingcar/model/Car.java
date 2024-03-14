package racingcar.model;

public class Car {
    private static final int MOVE_STANDARD = 4;
    private static final int MOVE_DISTANCE = 1;
    private static final int BASE_DISTANCE = 0;

    private final String carName;
    private int distance;

    public Car(String carName) {
        this.carName = carName;
        this.distance = 0;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getCarName() { return this.carName; }

    public void move(int movableNumber) {
        if (movableNumber >= MOVE_STANDARD) {
            distance += MOVE_DISTANCE;
        }
    }

    public boolean matchDistance(int distance) {
        return this.distance == distance;
    }
}
