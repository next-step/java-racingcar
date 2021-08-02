package step5.domain.race;

import step5.domain.car.Cars;

public class RacingGame {

    private static final int GAME_COUNT_LOWER_BOUND = 0;
    private final Cars cars;

    private int remainGameCount;
    private boolean isFirstRace;

    public RacingGame(String[] carNames, int remainGameCount) {
        this.cars = new Cars(carNames);
        this.remainGameCount = remainGameCount;
        this.isFirstRace = true;
    }

    public RaceResult race() {
        validateLimit();
        remainGameCount--;
        cars.tryMove();
        return generateRaceResult();
    }

    private RaceResult generateRaceResult() {
        if (isFirstRace) {
            RaceResult raceResult = new RaceResult(this, cars, true);
            isFirstRace = false;
            return raceResult;
        }
        return new RaceResult(this, cars, false);
    }

    public boolean isFinished() {
        return remainGameCount == GAME_COUNT_LOWER_BOUND;
    }

    private void validateLimit() {
        if (remainGameCount <= GAME_COUNT_LOWER_BOUND)
            throw new IllegalStateException("remainGameCount is zero");
    }
}
