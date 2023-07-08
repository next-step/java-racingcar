package racingcar.car.domain;

import java.util.List;

public class CarGameManager {

    private final Cars cars;
    private final int playCount;
    private final MoveStrategy moveStrategy;

    public CarGameManager(String[] carNames, int playCount) {
        this.cars = new Cars(carNames);
        this.playCount = playCount;
        this.moveStrategy = new RandomMoveStrategy();
    }

    public void race() {
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
