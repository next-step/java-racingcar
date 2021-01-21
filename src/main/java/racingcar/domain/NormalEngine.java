package racingcar.domain;

import java.util.Random;

public class NormalEngine implements Engine{
    private static final int MOVING_POINT = 4;
    private final Random random = new Random(System.currentTimeMillis());

    @Override
    public boolean isMove() {
        int movingPoint = random.nextInt(10);
        return movingPoint >= MOVING_POINT;
    }
}
