package racingcar;

import util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {
    private static final String RACE_TRACK = "-";
    private static final String DELIMITER = " : ";

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

    public List<String> getResultByAttempt(int attempt) {
        return raceRecords.getRaceRecords().stream()
                .map(raceRecord -> raceRecord.getName()
                        + DELIMITER
                        + StringUtils.repeat(RACE_TRACK, raceRecord.getBy(attempt)))
                .collect(Collectors.toList());
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
