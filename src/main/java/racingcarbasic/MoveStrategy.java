package racingcarbasic;

public interface MoveStrategy {
    boolean move(int step);
}

class StraightMove implements MoveStrategy {
    @Override
    public boolean move(int num) {
        return num >= 4;
    }
}