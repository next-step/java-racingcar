package domain;

public class AlwaysMoveStrategy implements MoveStrategy{
    @Override
    public boolean isCanMove() {
        return true;
    }
}
