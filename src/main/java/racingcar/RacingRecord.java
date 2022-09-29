package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingRecord {
    private static final List<RoundCars> records = new ArrayList<>();
    private static final List<String> winners = new ArrayList<>();

    public List<RoundCars> retrieveRecord() {
        return records;
    }

    public void addCarsPosition(RoundCars roundCars) {
        records.add(roundCars.deepCopy());
    }

    public List<String> retrieveWinners() {
        return winners;
    }

    public void addWinners(List<String> winnersParam) {
        winners.addAll(winnersParam);
    }
}
