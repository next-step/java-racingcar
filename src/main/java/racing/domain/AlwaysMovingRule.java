package racing.domain;

public class AlwaysMovingRule implements MovingRule {
    @Override
    public boolean isPossibleToMove() {
        return true;
    }
}
