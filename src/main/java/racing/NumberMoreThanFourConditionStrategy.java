package racing;

public class NumberMoreThanFourConditionStrategy implements ForwardConditionStrategy {
    private final int CONDITION = 4;

    @Override
    public boolean judgeCondition() {
        return !(RandomNumberGenerator.generate() >= CONDITION);
    }
}
