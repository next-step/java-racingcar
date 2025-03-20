package step3.game.domain;

import step3.game.domain.car.CarName;
import step3.game.domain.car.Players;

import java.util.Set;

public class RacingCarGame {

    public static final int MOVE_CRITERIA = 4;

    private final RacingCarInfo carInfo;

    public RacingCarGame(Set<CarName> carNames, PositiveNumber tryCount) {
        this.carInfo = RacingCarInfo.of(carNames, tryCount);
    }

    public void takeTurn() {
        carInfo.players.takeTurn();
    }

    public Players getCars() {
        return carInfo.players;
    }

    public static boolean isMove(int randomNumber) {
        return randomNumber >= MOVE_CRITERIA;
    }
}
