package racing.domain;

public class AlwaysStopMovingStrategy implements MovingStrategy {
    @Override
    public boolean isMove() {
        return false;
    }
}
