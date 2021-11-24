package racingcar.domain;

public class LoadMovable implements Movable {
    private static final int MOVE_CONDITION = 4;

    @Override
    public boolean move(int num) {
        return num >= MOVE_CONDITION;
    }
}
