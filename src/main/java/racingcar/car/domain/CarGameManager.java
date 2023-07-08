package racingcar.car.domain;

import java.util.List;

public class CarGameManager {

    private final Cars cars;
    private final int playCount;

    public CarGameManager(String[] carNames, int playCount) {
        this.cars = new Cars(carNames);
        this.playCount = playCount;
    }

    public void race() {
        cars.move(new RandomMoveStrategy());
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
