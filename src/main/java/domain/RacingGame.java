package domain;

import movingStrategy.Moveable;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final TryCount tryCount;
    private final RacingCarNames racingCarNames;
    private final Moveable moveable;

    public RacingGame(RacingCarNames racingCarNames, TryCount tryCount, Moveable moveable) {
        this.tryCount = tryCount;
        this.racingCarNames = racingCarNames;
        this.moveable = moveable;
    }

    public RacingGame(String[] racingCarNamesArray, Integer tryCountInteger, Moveable moveable) {
        this.racingCarNames = new RacingCarNames(racingCarNamesArray);
        this.tryCount = new TryCount(tryCountInteger);
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
        RacingCars racingCars = new RacingCars(racingCarNames);
        List<Boolean> carsMoveable = checkMoveableCars();

        RacingCars movedRacingCars = racingCars.moveRacingCars(carsMoveable);
        RoundResult roundResult = new RoundResult(movedRacingCars);
        racingGameResult.addRoundResult(roundResult);
    }

    private List<Boolean> checkMoveableCars() {
        List<Boolean> carsMoveable = new ArrayList<>();
        for (int i=0; i < racingCarNames.length(); i++) {
            carsMoveable.add(moveable.isMoveable());
        }
        return carsMoveable;
    }
}
