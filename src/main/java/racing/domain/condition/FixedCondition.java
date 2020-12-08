package racing.domain.condition;

public class FixedCondition implements MovingCondition {
    private final int possibleCondition;

    public FixedCondition(int possibleCondition) {
        this.possibleCondition = possibleCondition;
    }

    @Override
    public int getCondition() {
        return possibleCondition;
    }
}
