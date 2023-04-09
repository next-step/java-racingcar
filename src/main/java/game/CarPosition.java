package game;

public class CarPosition {

    private static final int MOVE_CRITERIA = 4;
    private final CarActionRecord carActionRecord = new CarActionRecord();

    public void addRecord(int number) {
        if (isMove(number)) {
            carActionRecord.addMove();
            return;
        }
        carActionRecord.addStop();
    }

    private boolean isMove(int number) {
        return number >= MOVE_CRITERIA;
    }

    public CarActionRecord carActionRecord() {
        return carActionRecord;
    }
}