package racingcar.service;

import racingcar.model.*;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private RacingRound racingRound;
    private RacingRecord racingRecord;
    private int racingCount;

    public RacingGame(int racingCarNumber, int racingCount) {
        this.racingCount = racingCount;
        this.racingRound =  participate(racingCarNumber);
        this.racingRecord = new RacingRecord();
    }

    public RacingRecord start() {
        for (int i = 0; i < racingCount; i++) {
            racingRound.race(adjustRule());
            racingRecord.record(racingRound);
        }
        return racingRecord;
    }

    public RacingRound participate(int racingCarNumber) {
        List<RacingCar> cars = new ArrayList<>();
        for (int i = 0; i < racingCarNumber; i++) {
            cars.add(new RacingCar(String.valueOf(i)));
        }
        return new RacingRound(cars);
    }

    public Rule adjustRule() {
        return new RacingRule();
    }

}
