package racingcar;

import static racingcar.domain.RandomRacingRule.RacingRandom.randomNumbers;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.LapResult;
import racingcar.domain.RaceResults;
import racingcar.domain.RacingRule;

public class Racing {

    private final Cars cars;
    private final Integer lapCount;
    private final RaceResults raceResults;
    private final RacingRule racingRule;

    public Racing(Cars cars, int lapCount, RaceResults raceResults, RacingRule racingRule) {
        this.cars = cars;
        this.lapCount = lapCount;
        this.raceResults = raceResults;
        this.racingRule = racingRule;
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
        cars.raceLap(movableList());
    }

    private List<Boolean> movableList() {
        return racingRule.movableList(randomNumbers(carSize()));
    }

    private int carSize() {
        return cars.cars().size();
    }

    private void recordLapResult() {
        raceResults.recordLapResult(new LapResult(cars.clone().cars()));
    }

    public Cars cars() {
        return cars.clone();
    }

    public Integer raceCount() {
        return lapCount;
    }

    public RaceResults raceResults() {
        return raceResults;
    }

}
