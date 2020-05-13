package racingcar.domain;

import java.util.Random;

public class RandomStrategy implements Strategy {
    private static final int BOUND = 10;
    private static final int MOVABLE_CONDITION = 4;

    @Override
    public boolean isMove() {
        int random = new Random().nextInt(BOUND);
        return random >= MOVABLE_CONDITION;
    }
}
