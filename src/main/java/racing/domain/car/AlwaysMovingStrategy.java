package racing.domain.car;

public class AlwaysMovingStrategy implements MovingStrategy {
    @Override
    public boolean isPossibleToMove() {
        return true;
    }
}
