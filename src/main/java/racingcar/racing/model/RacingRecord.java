package racingcar.racing.model;


public class RacingRecord implements Comparable<RacingRecord> {

    private static final int POSITIVE_NUMBER = 1;
    private static final int NEGATIVE_NUMBER = -1;
    private static final int SAME_NUMBER = 0;

    private final int tryNumber;
    private final int carId;
    private final int curPos;
    private final String participantName;

    public RacingRecord(int carId, int curPos, int tryNumber, String participantName) {
        this.carId = carId;
        this.curPos = curPos;
        this.tryNumber = tryNumber;
        this.participantName = participantName;
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

    public String getParticipantName() {
        return participantName;
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
