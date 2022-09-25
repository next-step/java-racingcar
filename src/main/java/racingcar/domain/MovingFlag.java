package racingcar.domain;

public class MovingFlag {
    private final int movingValue;

    public MovingFlag(int movingValue) {
        this.movingValue = movingValue;
    }

    public boolean canMove() {
        return movingValue >= 4;
    }
}
