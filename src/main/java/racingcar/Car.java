package racingcar;

public class Car {
    private static final int INITIAL_DISTANCE = 0;
    private static final int MOVING_STANDARD = 4;
    private final String carName;
    private int distance;

    public Car(String carName) {
        this.distance = INITIAL_DISTANCE;
        this.carName = carName;
    }

    public Car(int distance, String carName) {
        this.distance = distance;
        this.carName = carName;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVING_STANDARD) {
            distance += 1;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return carName;
    }

    public boolean isWinner(int distance) {
        return distance == this.distance;
    }
}
