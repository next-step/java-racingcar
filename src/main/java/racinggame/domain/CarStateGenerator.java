package racinggame.domain;

import java.util.Random;

public class CarStateGenerator implements StateGenerator{

    private static final Integer MIN_MOVE_VALUE = 4;
    private static final Integer MAX_MOVE_VALUE = 9;

    private final Random random;

    public CarStateGenerator() {
        random = new Random();
    }

    @Override
    public State getState() {
        if (MIN_MOVE_VALUE <= random.nextInt(MAX_MOVE_VALUE)) {
            return State.MOVE;
        }
        return State.STOP;
    }
}
