package racinggame.game;

import racinggame.domain.car.MovableStrategy;
import racinggame.domain.car.RacingCars;
import racinggame.domain.car.RandomMovableStrategy;

public class RacingGame {

    private RacingCars racingCars;

    public RacingGame(String[] carNames) {
        this.racingCars = RacingCars.newInstance(carNames, new RandomMovableStrategy());
    }

    public RacingCars start() {
        this.racingCars.moveAll();
        return this.racingCars;
    }

    public String getWinnerCarNames() {
        return this.racingCars.getWinnerCarNames();
    }

    public void changeMovableStrategy(MovableStrategy movableStrategy) {
        this.racingCars.changeMovableStrategy(movableStrategy);
    }
}
