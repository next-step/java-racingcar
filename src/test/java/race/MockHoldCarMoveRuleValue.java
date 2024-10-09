package race;

public class MockHoldCarMoveRuleValue implements CarMoveRuleValue {
    @Override
    public boolean isGreaterThanOrEqualTo(int value) {
        return true;
    }
}
