package racingcar.car.controller;

import java.util.List;
import racingcar.car.domain.Car;
import racingcar.car.domain.Cars;
import racingcar.car.domain.MoveStrategy;
import racingcar.car.domain.RandomMoveStrategy;

public class CarGameManager {

    private int playCount;
    private final Cars cars;
    private final MoveStrategy moveStrategy;

    public CarGameManager(String[] carNames, int playCount) {
        this.cars = new Cars(carNames);
        this.playCount = playCount;
        this.moveStrategy = new RandomMoveStrategy();
    }

    public void race() {
        if (!isRunning()) {
            throw new IllegalStateException("이미 종료된 게임입니다.");
        }
        playCount--;
        cars.move(moveStrategy);
    }

    public boolean isRunning() {
        return playCount > 0;
    }

    public List<Car> getMiddleState() {
        return cars.getCars();
    }

    public List<Car> getResult() {
        return cars.getWinners();
    }
}
