package newcarracing.domain;

import java.util.Random;

public class RandomRuleCondition implements RuleCondition{
    private static final Random random = new Random();
    private static final int ZERO_TO_NINE = 10;

    @Override
    public boolean checkCondition() {
        return random.nextInt(ZERO_TO_NINE) >= 4;
    }
}
