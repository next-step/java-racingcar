package race;

public class MockCarRandomMoveRuleValue implements CarMoveRuleValue {
    private final int value;

    public MockCarRandomMoveRuleValue(int value) {
        this.value = value;
    }

    public MockCarRandomMoveRuleValue(int startInclusive, int endExclusive) {
        this.value = (int) (Math.random() * endExclusive - 1) + startInclusive;
    }

    @Override
    public boolean isGreaterThanOrEqualTo(int value) {
        return this.value >= value;
    }
}
