package racingcar.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class RacingResult {

    private int attempt;
    private List<RaceRecord> raceRecords;

    private RacingResult(int attempt, List<RaceRecord> raceRecords) {
        this.attempt = attempt;
        this.raceRecords = raceRecords;
    }

    private static RacingResult create(int attempt, List<RaceRecord> raceRecords) {
        return new RacingResult(attempt, raceRecords);
    }

    public static RacingResult aggregate(int attempt, RacingCars racingCars) {
        return RacingResult.create(attempt, racingCars.getRaceRecords());
    }

    public int getAttempt() {
        return attempt;
    }

    public Map<String, Integer> getResultByAttempt(int attempt) {
        return raceRecords.stream()
                .collect(toMap(RaceRecord::getName, raceRecord -> raceRecord.getBy(attempt)));
    }

    public String getWinner() {
        long winnerRecord = raceRecords.stream()
                .map(RaceRecord::getLastRecord)
                .reduce(0, Math::max);

        return raceRecords.stream()
                .filter(raceRecord -> raceRecord.getLastRecord() == winnerRecord)
                .map(RaceRecord::getName)
                .collect(Collectors.joining(","));
    }
}
