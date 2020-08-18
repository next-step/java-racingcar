package racingcarbasic;

class StraightMove implements MoveStrategy {
    @Override
    public boolean move(int num) {
        return num >= 4;
    }
}
