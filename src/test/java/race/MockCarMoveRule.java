package race;

public class MockCarMoveRule implements CarMoveRule {
    @Override
    public boolean check(CarMoveRuleValue value) {
        return value instanceof MockForwardCarMoveRuleValue;
    }
}
