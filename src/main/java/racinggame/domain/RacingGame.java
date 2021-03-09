package racinggame.domain;

public class RacingGame {
    private static final int MAX_BOUND = 10;

    private final Cars cars;
    private final TryNo tryNo;

    public RacingGame(String carNames, int tryNo) {
        this.cars = new Cars(carNames);
        this.tryNo = new TryNo(tryNo);
    }

    public void race() {
        tryNo.race();
        cars.move();
    }

    public boolean racing() {
        return tryNo.racing();
    }

    public Cars getCars() {
        return this.cars;
    }

    public Winners getWinners() {
        return cars.findWinners();
    }
}
