package racinggame.domain;

public class RamdomCondition implements ConditionInterface {
    private static final int ADVANCE_CONDITION = 4;
    private final RandomValue randomValue;

    RamdomCondition(RandomValue randomValue) {
        this.randomValue = randomValue;
    }

    public boolean meet() {
        return randomValue.meet(ADVANCE_CONDITION);
    }
}
