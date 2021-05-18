package racing.domain;

public class OverFourStrategy implements MoveConditionStrategy {
    @Override
    public int getMoveChangeCondition() {
        return 4;
    }
}
