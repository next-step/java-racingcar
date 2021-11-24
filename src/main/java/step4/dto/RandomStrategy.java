package step4.dto;

import java.util.Random;

public class RandomStrategy implements RunStrategy {
    private static final int BASE = 10;
    private static final int CONDITION = 4;

    @Override
    public boolean runnable() {
        return isValueMoreThanCondition();
    }

    private boolean isValueMoreThanCondition() {
        return new Random().nextInt(BASE) >= CONDITION;
    }
}
