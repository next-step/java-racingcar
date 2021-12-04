package step3;

public class RamdomCondition implements ConditionInterface{
    private static final int ADVANCE_CONDITION = 4;
    private final RandomValue randomValue;

    RamdomCondition(RandomValue randomValue) {
        this.randomValue = randomValue;
    }

    // randomValue를 생성자에서 주입되도록 해도 meet 테스트가 가능!
    public boolean meet() {
        return randomValue.meet(ADVANCE_CONDITION);
    }
}
