package step4;

import java.util.Random;

public class RandomMoveRule implements MoveRule{
    private static final int BETWEEN_ZERO_AND_NINE = 10;
    private static final int CONDITION = 4;
    private static final Random random = new Random();

    @Override
    public boolean passCondition() {
        return getRandomNum() >= CONDITION;
    }

    public int getRandomNum() {
        return random.nextInt(BETWEEN_ZERO_AND_NINE);
    }

}
