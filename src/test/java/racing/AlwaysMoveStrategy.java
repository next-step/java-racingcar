package racing;

public class AlwaysMoveStrategy implements MovableStrategy{
    @Override
    public boolean canMove() {
        return true;
    }
}
