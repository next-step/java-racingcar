package racing.domain;

public class CarPosition {
    private static final int INITIAL_POSITION = 0;
    private int position;
    private final PositionRecord positionRecord;

    public CarPosition() {
        this(INITIAL_POSITION);
    }

    public CarPosition(int position) {
        this.position = position;
        this.positionRecord = new PositionRecord();
    }

    public void movePosition() {
        position++;
    }

    public void save() {
        positionRecord.save(position);
    }

    public int getPositionRecord(int index) {
        return positionRecord.getRecordStatus(index);
    }

    public int getPosition() {
        return position;
    }

    public static CarPosition ofStartingPoint() {
        return new CarPosition();
    }

}
