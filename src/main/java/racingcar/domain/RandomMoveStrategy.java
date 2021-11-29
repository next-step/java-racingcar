package racingcar.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int BOUND = 10;
    private static final Random random = new Random();
    private static final int MAX_MOVE_NUM = 4;

    @Override
    public int moveValue() {
        return resultValue(random.nextInt(BOUND));
    }

    private int resultValue(int value) {
        if (value >= MAX_MOVE_NUM) {
            return 1;
        }
         return 0;
    }

}
