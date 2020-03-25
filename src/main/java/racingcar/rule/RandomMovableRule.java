package racingcar.rule;

import java.util.Random;

public class RandomMovableRule implements MovableRuleGenerator {
    private static final int RANDOM_RANGE = 10;

    // 랜덤값이 해당 값 이상일때만 move
    private static final int MORE_THAN_VALUE_FOR_CAR_MOVE = 4;

    @Override
    public boolean isMovable() {
        Random random = new Random();

        if (random.nextInt(RANDOM_RANGE) > MORE_THAN_VALUE_FOR_CAR_MOVE) {
            return true;
        }
        return false;
    }
}
