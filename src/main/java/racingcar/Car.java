package racingcar;

public class Car {

    private static final int MOVABLE_MIN_NUMBER = 4;

    private final RandomPicker randomPicker;

    private CarStatus carStatus;

    public Car(RandomPicker randomPicker) {
        this.randomPicker = randomPicker;
        this.carStatus = CarStatus.init();
    }

    public CarStatus game() {
        if (isMovable(randomPicker.pickNumber())) {
            moveForward();
        }

        return carStatus;
    }

    private boolean isMovable(int number) {
        return number >= MOVABLE_MIN_NUMBER;
    }

    private void moveForward() {
        this.carStatus = carStatus.moveForward();
    }
}
