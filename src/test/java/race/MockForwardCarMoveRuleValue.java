package race;

public class MockForwardCarMoveRuleValue implements CarMoveRuleValue {
    @Override
    public boolean isGreaterThanOrEqualTo(int value) {
        return true;
    }
}
