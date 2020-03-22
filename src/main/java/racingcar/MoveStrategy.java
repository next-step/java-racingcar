package racingcar;

import java.util.Random;

public class MoveStrategy {

    public static final int NUMBER_GENERATE_RANGE = 9;
    public static final int CAN_MOVE_RANGE = 4;

    public boolean movable() {
        return new Random().nextInt(NUMBER_GENERATE_RANGE) >= CAN_MOVE_RANGE;
    }
}
