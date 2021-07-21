package racing;

public class NumberMoreThanFourConditionStrategy implements ForwardConditionStrategy {
    @Override
    public boolean judgeCondition() {
        return !(RandomNumberGenerator.generate() >= 4);
    }
}
