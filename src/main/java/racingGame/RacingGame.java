package racingGame;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final TryNumber tryNumber;
    private final MoveStrategy strategy;

    private PlayCount playCount = PlayCount.zero();

    public RacingGame(String carNames, int tryNo) {
        this(CarNames.from(carNames), new TryNumber(tryNo), new RandomMoveStrategy());
    }

    public RacingGame(List<String> names, int tryNo, MoveStrategy strategy) {
        this(CarNames.from(names), new TryNumber(tryNo), strategy);
    }

    private RacingGame(CarNames carNames, TryNumber tryNumber, MoveStrategy strategy) {
        this.cars = carNames.toCars();
        this.tryNumber = tryNumber;
        this.strategy = strategy;
    }
    public boolean hasNextRound() {
        return playCount.isLessThan(tryNumber);
    }

    public void race() {
        moveCars();
        playCount = playCount.increase();
    }

    protected void moveCars() {
        cars.moveAll(strategy);
    }
    public List<Car> getCars() {
        return cars.asList();
    }
    public List<String> findWinners() {
        return cars.winnerNames();
    }
}
