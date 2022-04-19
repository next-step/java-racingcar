package racingcar.racing.model;


public class RacingRecord implements Comparable<RacingRecord> {

    private static final int POSITIVE_NUMBER = 1;
    private static final int NEGATIVE_NUMBER = -1;
    private static final int SAME_NUMBER = 0;

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


    @Override
    public int compareTo(RacingRecord racingRecord) {
        if (carId > racingRecord.carId) {
            return POSITIVE_NUMBER;
        }

        if (carId < racingRecord.carId) {
            return NEGATIVE_NUMBER;
        }

        return SAME_NUMBER;
    }
}
