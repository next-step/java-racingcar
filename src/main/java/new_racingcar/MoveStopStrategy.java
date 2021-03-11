package new_racingcar;

public class MoveStopStrategy implements MoveStrategy {
    public static final MoveStopStrategy INSTANCE = new MoveStopStrategy();

    private void MoveStopStrategy() { }

    @Override
    public boolean move(Record record) {
        return false;
    }

}
