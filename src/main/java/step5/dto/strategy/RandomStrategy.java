package step5.dto.strategy;

import java.util.Random;

public class RandomStrategy implements RunStrategy {
    private static final int BASE = 10;
    private static final int CONDITION = 4;
    private static final Random RANDOM = new Random();

    @Override
    public boolean runnable() {
        return isValueMoreThanCondition();
    }

    private boolean isValueMoreThanCondition() {
        return RANDOM.nextInt(BASE) >= CONDITION;
    }
}
