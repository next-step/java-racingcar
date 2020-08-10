package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RaceRecords {
    private final List<RaceRecord> raceRecords;

    public RaceRecords(List<RaceRecord> raceRecords) {
        this.raceRecords = raceRecords;
    }

    public List<String> getResultByAttempt(int attempt) {
        return raceRecords.stream()
                .map(raceRecord -> raceRecord.getResultStringByAttempt(attempt))
                .collect(Collectors.toList());
    }

    public String getWinner(int lastAttempt) {
        int winnerRecord = raceRecords.stream()
                .map(raceRecord -> raceRecord.getBy(lastAttempt))
                .reduce(0, Math::max);

        return raceRecords.stream()
                .filter(raceRecord -> raceRecord.getBy(lastAttempt) == winnerRecord)
                .map(RaceRecord::getName)
                .collect(Collectors.joining(","));
    }
}
