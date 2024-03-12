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

    public static RaceRecordOfCar newRaceResult(final String carName, final int position, final List<Integer> positionHistory) {
        return new RaceRecordOfCar(carName, position, positionHistory);
    }

    public String carName() {
        return carName;
    }

    public int position() {
        return position;
    }

    public List<Integer> positionHistory() {
        return Collections.unmodifiableList(positionHistory);
    }

    public int positionOfRound(int round) {
        return positionHistory.get(round);
    }
}
