package step3.manager;

import step3.MyException;

public class RandomManager implements RacingManager {
    private final int TEN = 10;
    private final int RUN_CONDITION_VALUE = 4;

    @Override
    public boolean checkRunCondition() {
        return randomCount() >= RUN_CONDITION_VALUE;
    }

    private int randomCount() {
        return (int)(Math.random() * TEN);
    }
}
