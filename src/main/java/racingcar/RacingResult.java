package racingcar;

import java.util.List;

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

    public List<String> getResultByAttempt(int attempt) {
        return raceRecords.getResultByAttempt(attempt);
    }

    public String getWinner(int lastAttempt) {
        return raceRecords.getWinner(lastAttempt);
    }
}
