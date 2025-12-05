package racing.controller;

import racing.domain.Cars;
import racing.domain.MoveStrategy;
import racing.domain.RaceResult;
import racing.domain.RandomMoveStrategy;
import racing.domain.RandomNumberGenerator;
import racing.domain.RoundResult;
import racing.view.OutputView;

public class Game {

    private final Cars cars;
    private final int tryCount;

    public Game(int carCount, int tryCount) {
        this.cars = new Cars(carCount);
        this.tryCount = tryCount;
    }

    public void race() {
        MoveStrategy moveStrategy = createMoveStrategy();
        RaceResult raceResult = new RaceResult();

        for (int i = 0; i < tryCount; i++) {
            playSingleRound(moveStrategy, raceResult);
        }

        OutputView.printRaceResult(raceResult);
    }

    private MoveStrategy createMoveStrategy() {
        return new RandomMoveStrategy(new RandomNumberGenerator());
    }

    private void playSingleRound(MoveStrategy moveStrategy, RaceResult raceResult) {
        cars.moveCars(moveStrategy);
        RoundResult roundResult = cars.roundResult();
        raceResult.addResult(roundResult);
    }
}
