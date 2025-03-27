package domain;

import movingStrategy.Moveable;

public class RacingGame {
    private final TryCount tryCount;
    private final RacingCars racingCars;
    private final Moveable moveable;

    public RacingGame(RacingCarNames racingCarNames, TryCount tryCount, Moveable moveable) {
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

    public static RacingGame of(String[] racingCarNamesArray, Integer tryCountInteger, Moveable moveable) {
        RacingCarNames racingCarNames = new RacingCarNames(racingCarNamesArray);
        TryCount tryCount = new TryCount(tryCountInteger);
        return new RacingGame(racingCarNames, tryCount, moveable);
    }
}
