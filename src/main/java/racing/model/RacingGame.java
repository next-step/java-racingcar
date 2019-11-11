package racing.model;

import java.util.List;

public class RacingGame {

    private int time;
    private Cars racingCars;

    public RacingGame(Cars racingCars, int time) {
        this.racingCars = racingCars;
        this.time = time;
    }

    public void race(List<Integer> randomValues) {
        this.time -= 1;
        this.racingCars.race(randomValues);
    }

    public boolean hasTime() {
        return this.time > RacingConstant.ZERO_NUMBER;
    }

    public Cars getCars() {
        return this.racingCars;
    }
}
