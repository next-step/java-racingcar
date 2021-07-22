package racing.domain;

public class Car {
    private static final int INITIAL_POSITION = 0;
    private int position;
    private final PositionRecord positionRecord;

    public Car() {
        this.position = INITIAL_POSITION;
        this.positionRecord = new PositionRecord();
    }

    public void race(MovingStrategy strategy) {
        if (strategy.isMove()) {
            position++;
        }

        positionRecord.save(position);
    }

    public PositionRecord getPositionRecord() {
        return positionRecord;
    }

    protected int getPosition() {
        return position;
    }
}
