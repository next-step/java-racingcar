package model;

import java.util.List;

public class CarRacingGame {
    private TryCount tryCount;
    Cars cars;


    // Cars를 가지고 있는 것이 어떨까?
    public CarRacingGame(int tryCount, String carNames) {
        this.tryCount = new TryCount(tryCount);
        this.cars = new Cars(carNames);
    }

    public void race() {
        tryCount.increase();
        cars.move();
    }

    public List<String> findWinner() {
        Position maxPosition = cars.getMaxPosition();
        return cars.getWinners(maxPosition);
    }

    public boolean isFinished() {
        return tryCount.isEnd();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}
