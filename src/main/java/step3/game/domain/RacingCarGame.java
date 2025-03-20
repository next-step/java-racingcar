package step3.game.domain;

import step3.game.domain.car.Car;
import step3.game.domain.car.CarName;
import step3.game.domain.car.Players;

import java.util.Set;

import static step3.game.domain.RandomGenerator.getRandomValue;

public class RacingCarGame {

    public static final int MOVE_CRITERIA = 4;

    private final RacingCarInfo carInfo;

    public RacingCarGame(Set<CarName> carNames, PositiveNumber tryCount) {
        this.carInfo = RacingCarInfo.getCars(carNames, tryCount);
    }

    public void takeTurn() {
        for (Car car : carInfo.players.getCars()) {
            makeMove(car);
        }
    }

    private void makeMove(Car car) {
        if (isMove(getRandomValue())) {
            car.move();
        }
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= MOVE_CRITERIA;
    }

    public Players getCars() {
        return carInfo.players;
    }
}
