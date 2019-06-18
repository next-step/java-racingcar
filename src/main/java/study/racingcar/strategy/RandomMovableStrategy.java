package study.racingcar.strategy;

import java.util.Random;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class RandomMovableStrategy implements MovableStrategy {
    private static final Random RANDOM = new Random();
    private static final int NUMBER_OF_CASE = 10;
    private static final int CAN_MOVING_CONDITION = 4;

    public boolean canMove() {
        return RANDOM.nextInt(NUMBER_OF_CASE) >= CAN_MOVING_CONDITION;
    }
}
