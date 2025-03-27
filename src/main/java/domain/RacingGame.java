package domain;

import movingStrategy.Moveable;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final RacingCarNames racingCarNames;
    private final TryCount tryCount;
    private final RacingCars racingCars;
    private final Moveable moveable;

    public RacingGame(RacingCarNames racingCarNames, TryCount tryCount, Moveable moveable) {
        this.racingCarNames = racingCarNames;
        this.tryCount = tryCount;
        this.racingCars = new RacingCars(racingCarNames);
        this.moveable = moveable;
    }

    public RacingGameResult start() {
        RacingGameResult racingGameResult = new RacingGameResult();
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            progressRound(racingGameResult);
        }
        return racingGameResult;
    }

    private void progressRound(RacingGameResult racingGameResult) {
        racingCars.moveRacingCars(moveable);
        racingGameResult.addRoundResult(new RoundResult(racingCars));
    }

    private List<RacingCar> initializeRacingCars() {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : racingCarNames.getRacingCarNames()) {
            racingCars.add(new RacingCar(name));
        }
        return racingCars;
    }

    public static RacingGame of(String[] racingCarNamesArray, Integer numberOfTrialInteger, Moveable moveable) {
        RacingCarNames racingCarNames = new RacingCarNames(racingCarNamesArray);
        TryCount tryCount = new TryCount(numberOfTrialInteger);
        return new RacingGame(racingCarNames, tryCount, moveable);
    }
}
