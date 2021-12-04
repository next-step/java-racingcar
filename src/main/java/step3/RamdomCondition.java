package step3;

public class RamdomCondition implements ConditionInterface{
    private static final int ADVANCE_CONDITION = 4;

    public boolean meet(RandomValue randomValue) {
        return randomValue.meet(ADVANCE_CONDITION);
    }
}
