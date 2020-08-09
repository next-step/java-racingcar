package racingcar;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

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

    public static RacingResult aggregate(int attempt, List<RacingVehicle> racingCars) {
        RaceRecords raceRecords = racingCars.stream()
                .map(RacingVehicle::getRaceRecord)
                .collect(collectingAndThen(toList(), RaceRecords::new));

        return RacingResult.create(attempt, raceRecords);
    }

    public int getAttempt() {
        return attempt;
    }

    public List<Integer> getResultByAttempt(int attempt) {
        return raceRecords.getResultByAttempt(attempt);
    }
}
