package racinggame.game;

import racinggame.car.MovableStrategy;
import racinggame.car.RacingCars;

public class RacingGame {

    private RacingCars racingCars;

    public RacingGame(String[] carNames, MovableStrategy movableStrategy) {
        this.racingCars = RacingCars.newInstance(carNames, movableStrategy);
    }

    public RacingCars start() {
        this.racingCars.moveAll();
        return this.racingCars;
    }

    public String getWinnerCarNames() {
        return this.racingCars.getWinnerCarNames();
    }
}
