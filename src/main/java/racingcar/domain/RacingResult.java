package racingcar.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class RacingResult {

    private int attempt;
    private RaceRecords raceRecords;

    private RacingResult(int attempt, RaceRecords raceRecords) {
        this.attempt = attempt;
        this.raceRecords = raceRecords;
    }

    private static RacingResult create(int attempt, RaceRecords raceRecords) {
        return new RacingResult(attempt, raceRecords);
    }

    public static RacingResult aggregate(int attempt, RacingCars racingCars) {
        return RacingResult.create(attempt, racingCars.getRaceRecords());
    }

    public int getAttempt() {
        return attempt;
    }

    public Map<String, Integer> getResultByAttempt(int attempt) {
        return raceRecords.getRaceRecords()
                .stream()
                .collect(toMap(RaceRecord::getName, raceRecord -> raceRecord.getBy(attempt)));
    }

    public String getWinner(int lastAttempt) {
        List<RaceRecord> raceRecordList = raceRecords.getRaceRecords();

        int winnerRecord = raceRecordList.stream()
                .map(raceRecord -> raceRecord.getBy(lastAttempt))
                .reduce(0, Math::max);

        return raceRecordList.stream()
                .filter(raceRecord -> raceRecord.getBy(lastAttempt) == winnerRecord)
                .map(RaceRecord::getName)
                .collect(Collectors.joining(","));
    }
}
