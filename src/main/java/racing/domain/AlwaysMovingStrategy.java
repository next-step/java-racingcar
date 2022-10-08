package racing.domain;

public class AlwaysMovingStrategy implements MovingStrategy {
    @Override
    public boolean isPossibleToMove() {
        return true;
    }
}
