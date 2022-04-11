package racing.domain;

public class RandomMovement implements Movable<Integer> {
    private static final int STOP = 0;
    private static final int MOVE_FORWARD = 1;

    @Override
    public int moveForwardOrStop(Integer number) {
        if (number < 4) {
            return STOP;
        }

        return MOVE_FORWARD;
    }
}
