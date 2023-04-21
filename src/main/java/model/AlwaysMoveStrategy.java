package model;

public class AlwaysMoveStrategy implements MoveStrategy{
    @Override
    public int nextPosition(int currentPosition) {
        return currentPosition + 1;
    }
}
