package racing.infrastructure;

import racing.application.Condition;

import java.util.Random;

public class RandomCondition implements Condition {
    private final int BOUND = 9;
    private final int CONDITION = 4;

    @Override
    public boolean check() {
        return new Random().nextInt(BOUND) >= CONDITION;
    }
}
