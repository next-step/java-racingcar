package racing.domain;

import racing.util.RandomNumberGenerator;

public class NumberMoreThanFourConditionStrategy implements ForwardConditionStrategy {
    private static final NumberMoreThanFourConditionStrategy INSTANCE = new NumberMoreThanFourConditionStrategy();

    private final int CONDITION = 4;

    private NumberMoreThanFourConditionStrategy() {
    }

    public static NumberMoreThanFourConditionStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean judgeCondition() {
        return !(RandomNumberGenerator.generate() >= CONDITION);
    }
}
