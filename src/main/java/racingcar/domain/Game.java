package racingcar.domain;

public class Game {
    private final Cars cars;
    private int tryCount;

    public Game(Cars cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public boolean hasNextRound() {
        return tryCount > 0;
    }

    public ResultRound nextRound() {
        tryCount--;
        cars.doRound();
        return cars.getRound();
    }

    public ResultWinners computeWinner() {
        return cars.getWinners();
    }
}
