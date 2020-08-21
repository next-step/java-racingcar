package core;

public class AlwaysStopStrategy implements MoveStrategy {
    @Override
    public boolean isMove() {
        return false;
    }
}
