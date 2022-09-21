package racingcar;

public class RacingCar {

    private final Integer currentPosition;

    public RacingCar(Integer currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Integer currentPosition() {
        return currentPosition;
    }

    public static RacingCar positionOf(Integer position) {
        return new RacingCar(position);
    }

    public Integer nextPosition(Integer randomNumber) {
        if (randomNumber >= 4) {
            return currentPosition + 1;
        }
        return currentPosition;
    }
}
