package racinggame.domain.strategy;

public class AlwaysMoveStrategy implements MoveStrategy {
    @Override
    public boolean isMoveable() {
        return true;
    }
}
