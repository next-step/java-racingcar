package racingcar;

import racingcar.RacingRule.RacingRandom;

public class Racing {

    private final Cars cars;
    private final Integer lapCount;
    private final RaceResults raceResults;

    public Racing(Cars cars, int lapCount, RaceResults raceResults) {
        this.cars = cars;
        this.lapCount = lapCount;
        this.raceResults = raceResults;
    }

    public void playFullRace() {
        for (int l = 0; l < lapCount; l++) {
            playLap();
        }
    }

    private void playLap() {
        raceLap();
        recordLapResult();
    }

    private void raceLap() {
        cars.raceLap(RacingRule.movableList(RacingRandom.randomNumbers(cars.cars().size())));
    }

    private void recordLapResult() {
        raceResults.recordLapResult(new LapResult(cars.clone().cars()));
    }

    public Cars cars() {
        return cars;
    }

    public Integer raceCount() {
        return lapCount;
    }

    public RaceResults raceResults() {
        return raceResults;
    }

}
