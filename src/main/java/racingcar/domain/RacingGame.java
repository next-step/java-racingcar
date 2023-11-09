package racingcar.domain;

public class RacingGame {
    private int tryCount;

    private Cars cars;

    public RacingGame(int carCount, int tryCount) {
        this.tryCount = tryCount;
        this.cars = initRacing(carCount);
    }

    public Cars initRacing(int carCount) {
        cars = new Cars();
        for (int i = 0; i < carCount; i++) {
            cars.addCar(new Car());
        }
        return cars;
    }

    public boolean isEndGame() {
        return tryCount > 0 ? false : true;
    }

    public Cars start() {
        tryCount--;
        cars.moveCars();
        return cars;
    }
}
