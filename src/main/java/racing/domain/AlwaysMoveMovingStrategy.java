package racing.domain;

public class AlwaysMoveMovingStrategy implements MovingStrategy {
    @Override
    public boolean isMove() {
        return true;
    }
}
