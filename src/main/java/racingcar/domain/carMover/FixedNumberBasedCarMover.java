package racingcar.domain.carMover;

public class FixedNumberBasedCarMover implements NumberBasedCarMover {
    private static final int MOVING_DISTANCE = 1;
    private static final int MOVE_THRESHOLD = 4;

    private final int number;

    public FixedNumberBasedCarMover(int number) {
        this.number = number;
    }

    @Override
    public int move() {
        if (number >= MOVE_THRESHOLD) {
            return MOVING_DISTANCE;
        }
        return 0;
    }

}
