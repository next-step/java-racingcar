package racingcar;

public class LoadMovable implements Movable {
    private static final int MOVE_CONDITION = 4;

    @Override
    public boolean move(int num) {
        if (num >= MOVE_CONDITION)
            return true;
        return false;
    }
}
