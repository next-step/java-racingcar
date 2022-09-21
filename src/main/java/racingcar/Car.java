package racingcar;

public class Car {

    private final Integer currentPosition;

    private static final Integer MOVE_CRITERIA = 4;

    public Car(Integer currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Integer currentPosition() {
        return currentPosition;
    }

    public static Car positionOf(Integer position) {
        return new Car(position);
    }

    public Integer nextPosition(Integer randomNumber) {
        if (randomNumber >= MOVE_CRITERIA) {
            return currentPosition + 1;
        }
        return currentPosition;
    }
}
