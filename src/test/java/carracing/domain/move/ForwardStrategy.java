package carracing.domain.move;

public class ForwardStrategy implements MoveStrategy{
    @Override
    public boolean isMovable() {
        return true;
    }
}
