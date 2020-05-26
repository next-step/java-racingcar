package racingCar.domain;

import racingCar.domain.car.RacingCars;
import racingCar.domain.moveStrategy.MoveBehavior;
import racingCar.dto.RacingGameInfo;

public class RacingGame {
    private final RacingCars racingCars;

    public RacingGame(final RacingGameInfo racingGameInfo) {
        this.racingCars = new RacingCars(racingGameInfo.getCarNames());
    }

    public void move(MoveBehavior moveBehavior) {
        racingCars.move(moveBehavior);
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }
}
