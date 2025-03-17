package racing.rule;

public class FixedValueMoveRule extends MoveRule {
    private final int fixedValue;

    public FixedValueMoveRule(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public boolean isMovable() {
        return fixedValue >= MIN_MOVE_VALUE;
    }
}
