package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RaceRecords {
    private final List<RaceRecord> raceRecords;

    public RaceRecords(List<RaceRecord> raceRecords) {
        this.raceRecords = raceRecords;
    }

    public List<Integer> getResultByAttempt(int attempt) {
        return raceRecords.stream()
                .map(raceRecord -> raceRecord.getBy(attempt))
                .collect(Collectors.toList());
    }
}
