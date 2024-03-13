package carracing.model;

import java.util.Collections;
import java.util.List;

public class RaceRecordOfCar {
    private final String carName;
    private final int position;
    private final List<Integer> positionHistory;

    private RaceRecordOfCar(final String carName, final int position, final List<Integer> positionHistory) {
        this.carName = carName;
        this.position = position;
        this.positionHistory = positionHistory;
    }

    public static RaceRecordOfCar newRaceRecord(final String carName, final int position, final List<Integer> positionHistory) {
        return new RaceRecordOfCar(carName, position, positionHistory);
    }

    public String carName() {
        return carName;
    }

    public int position() {
        return position;
    }

    public boolean samePosition(int givenPosition) {
        return position == givenPosition;
    }

    public int positionByAttempt(int attempt) {
        return positionHistory.get(attempt);
    }
}
