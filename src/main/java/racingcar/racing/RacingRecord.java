package racingcar.racing;

public class RacingRecord {
    private final int tryNumber;
    private final int carId;
    private final int curPos;

    public RacingRecord(int carId, int curPos, int tryNumber) {
        this.carId = carId;
        this.curPos = curPos;
        this.tryNumber = tryNumber;
    }

    public int getTryNumber() {
        return tryNumber;
    }

    public int getCarId() {
        return carId;
    }

    public int getCurPos() {
        return curPos;
    }
    
}
