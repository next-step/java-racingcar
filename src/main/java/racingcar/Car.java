package racingcar;

public class Car {
    private static final Integer MOVE_CRITERIA = 4;

    private final Integer currentPosition;

    public Car(Integer currentPosition) {
        this.currentPosition = currentPosition;
    }

    public static Car positionOf(Integer position) {
        return new Car(position);
    }

    public Integer currentPosition() {
        return currentPosition;
    }

    public Integer nextPosition(Integer randomNumber) {
        if (randomNumber >= MOVE_CRITERIA) {
            return currentPosition + 1;
        }
        return currentPosition;
    }
}
