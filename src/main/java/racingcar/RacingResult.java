package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {

    private int attempt;
    private RaceRecords raceRecords;

    private RacingResult(int attempt, List<RaceRecord> raceRecords) {
        this.attempt = attempt;
        this.raceRecords = new RaceRecords(raceRecords);
    }

    private static RacingResult create(int attempt, List<RaceRecord> raceRecords) {
        return new RacingResult(attempt, raceRecords);
    }

    public static RacingResult aggregate(int attempt, List<RacingVehicle> racingCars) {
        List<RaceRecord> raceRecords = racingCars.stream()
                .map(RacingVehicle::getRaceRecord)
                .collect(Collectors.toList());

        return RacingResult.create(attempt, raceRecords);
    }

    public int getAttempt() {
        return attempt;
    }

    public List<Integer> getResultByAttempt(int attempt) {
        return raceRecords.getResultByAttempt(attempt);
    }
}
