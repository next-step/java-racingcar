package new_racingcar;

public class MoveOneStrategy implements MoveStrategy {
    public static final MoveOneStrategy INSTANCE = new MoveOneStrategy();

    private void MoveOneStrategy() { }

    @Override
    public boolean move(Record record) {
        record.addDistance();
        return true;
    }
}
