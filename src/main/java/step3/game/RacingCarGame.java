package step3.game;

import java.util.Set;

import static step3.game.RandomGenerator.getRandomValue;

public class RacingCarGame {

    public static final int MOVE_CRITERIA = 4;

    private final RacingCarInfo carInfo;

    RacingCarGame(Set<CarName> carNames, PositiveNumber tryCount) {
        this.carInfo = RacingCarInfo.getCars(carNames, tryCount);
    }

    public void takeTurn() {
        for (Car car : carInfo.cars) {
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

    public Set<Car> getCars() {
        return carInfo.cars;
    }
}
