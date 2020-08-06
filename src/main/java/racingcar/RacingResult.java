package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {

    private int attempt;
    private List<RaceRecord> result;

    private RacingResult(int attempt, List<RaceRecord> raceRecords) {
        this.attempt = attempt;
        this.result = raceRecords;
    }

    private static RacingResult create(int attempt, List<RaceRecord> raceRecords) {
        return new RacingResult(attempt, raceRecords);
    }

    public static RacingResult aggregate(int attempt, List<RacingCar> racingCars) {
        List<RaceRecord> raceRecords = racingCars.stream()
                .map(RacingCar::getRaceRecord)
                .collect(Collectors.toList());

        return RacingResult.create(attempt, raceRecords);
    }

    public int getAttempt() {
        return attempt;
    }

    public List<Integer> getResultByAttempt(int attempt) {
        return result.stream()
                .map(raceRecord -> raceRecord.getBy(attempt))
                .collect(Collectors.toList());
    }
}
