package study.racingcar.domain.car;

import java.util.Random;

public class OldEngine implements Engine{

    private static final OldEngine instance = new OldEngine();

    private static final Random randomValue = new Random();
    private static final int MOVE_GREATER_THAN = 4;

    public static OldEngine getInstance() {
        return instance;
    }

    @Override
    public boolean isMovable() {
        return randomValue.nextInt(10) > MOVE_GREATER_THAN;
    }
}
