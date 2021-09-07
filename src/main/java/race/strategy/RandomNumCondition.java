package race.strategy;

import java.util.Random;

public class RandomNumCondition implements MoveCondition {

    private final int STANDARD_NUM = 4;

    private final int LIMIT_NUM = 10;

    protected static final Random random = new Random();

    @Override
    public boolean moveOrNot() {
        return random.nextInt(LIMIT_NUM) >= STANDARD_NUM;
    }
}
