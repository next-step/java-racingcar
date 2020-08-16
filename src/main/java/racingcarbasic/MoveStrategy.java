package racingcarbasic;

public interface MoveStrategy {
    public boolean move(int step);
}

class StraightMove implements MoveStrategy {
    @Override
    public boolean move(int num) {
        if(num>=4) {
            return true;
        }
        return false;
    }
}