package racingcar;

public class Game {
    private final Cars cars;
    private final int tryCount;

    public Game(Cars cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void start() {
        for (int i = 0; i < tryCount; i++) {
            cars.doRound();
        }
        cars.printWinners();
    }
}
