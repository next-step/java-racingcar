package new_racingcar;

public class Car {
    private static final int MOVE_CONDITION = 4;

    private Record record;
    private MoveStrategy moveStrategy;

    public Car() {
        record = new Record();
    }

    public Record getRecord() {
        return record;
    }

    private void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    private MoveStrategy getMoveType(int randomValue) {
        if (randomValue >= MOVE_CONDITION) {
            return MoveOneStrategy.INSTANCE;
        }

        return MoveStopStrategy.INSTANCE;
    }

    public boolean move(int randomValue) {
        setMoveStrategy(getMoveType(randomValue));
        return moveStrategy.move(this.record);
    }
}
