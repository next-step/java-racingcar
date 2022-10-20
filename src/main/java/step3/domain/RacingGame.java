package step3.domain;

public class RacingGame {

    private final Cars cars;
    private final TryCount tryCount;

    public RacingGame(int carCount, int tryCount) {
        this.cars = new Cars(carCount);
        this.tryCount = new TryCount(tryCount);
    }

    public void race() {
        tryCount.race();
        cars.move();
    }

    public boolean racing() {
        return tryCount.racing();
    }

    public Cars getCars() {
        return cars;
    }
}
