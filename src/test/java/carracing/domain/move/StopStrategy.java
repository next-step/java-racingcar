package carracing.domain.move;

public class StopStrategy implements MoveStrategy{
    @Override
    public boolean isMovable() {
        return false;
    }
}
