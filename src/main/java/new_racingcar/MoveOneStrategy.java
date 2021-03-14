package new_racingcar;

public class MoveOneStrategy implements MoveStrategy {
    private static final int MOVE_CONDITION = 4;

    public static final MoveOneStrategy INSTANCE = new MoveOneStrategy();

    private void MoveOneStrategy() { }

    @Override
    public boolean isMove(int randomValue) {
        return MOVE_CONDITION <= randomValue;
    }
}
