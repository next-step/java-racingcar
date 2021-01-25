package racingcar.domain;

import java.util.Random;

public class NormalEngine implements Engine{
    private static final int MOVING_POINT = 4;
    private static final int RANDOM_BOUND = 10;
    private final Random random = new Random();

    @Override
    public boolean isMove() {
        int movingPoint = random.nextInt(RANDOM_BOUND);
        return movingPoint >= MOVING_POINT;
    }
}
