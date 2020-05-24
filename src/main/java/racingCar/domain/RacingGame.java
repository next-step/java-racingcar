package racingCar.domain;

import racingCar.domain.car.RacingCars;
import racingCar.domain.moveStrategy.MoveBehavior;
import racingCar.dto.RacingGameInfo;

public class RacingGame {
    private final int time;
    private RacingCars racingCars;

    public RacingGame(final RacingGameInfo racingGameInfo) {
        this.time = racingGameInfo.getTime();
        this.racingCars = new RacingCars(racingGameInfo.getCarNames());
    }

    // TODO 구현
    public void move(MoveBehavior moveBehavior) {
        racingCars.getRacingCarList().forEach(racingCar -> racingCar.move(moveBehavior.isMove()));
    }

    public int getTime() {
        return time;
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }
}
