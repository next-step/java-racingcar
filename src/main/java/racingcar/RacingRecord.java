package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingRecord {
    private final List<RoundCars> records = new ArrayList<>();
    private final List<String> winners = new ArrayList<>();

    public List<RoundCars> retrieveRecord() {
        return records;
    }

    public void addCarsPosition(RoundCars roundCars) {
        records.add(roundCars.getRoundCars());
    }

    public List<String> retrieveWinners() {
        return winners;
    }

    public void addWinners(List<String> winnersParam) {
        winners.addAll(winnersParam);
    }
}
