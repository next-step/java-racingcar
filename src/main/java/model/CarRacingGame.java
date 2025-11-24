package model;

import java.util.List;

public class CarRacingGame {
    private int tryCount;
    private int curTryCount;
    Cars cars;

    // Cars를 가지고 있는 것이 어떨까?
    public CarRacingGame(int tryCount, String carNames) {
        this.curTryCount = 0;
        this.tryCount = tryCount;
        this.cars = new Cars(carNames);
    }

    public void race() {
        this.curTryCount += 1;
        cars.move();
    }

    public List<String> findWinner() {
        int maxPosition = cars.getMaxPosition();
        return cars.getWinners(maxPosition);
    }

    public boolean isFinished() {
        return this.curTryCount == this.tryCount;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
