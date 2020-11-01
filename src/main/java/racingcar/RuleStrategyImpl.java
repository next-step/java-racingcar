package racingcar;

import java.util.Random;

public class RuleStrategyImpl implements RuleStrategy {

    public static final int THRESHOLD = 4;
    public static final int BOUND = 10;
    private static final Random random = new Random();

    @Override
    public boolean checkRule() {
        if (random.nextInt(BOUND) >= THRESHOLD)
            return true;
        
        return false;
    }
}
