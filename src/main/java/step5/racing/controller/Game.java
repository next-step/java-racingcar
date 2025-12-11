package step5.racing.controller;

import step5.racing.domain.CarNames;
import step5.racing.domain.Cars;
import step5.racing.domain.MoveStrategy;
import step5.racing.domain.RaceResult;
import step5.racing.domain.RandomMoveStrategy;
import step5.racing.domain.RandomNumberGenerator;
import step5.racing.domain.TryCount;
import step5.racing.view.OutputView;

public class Game {

    private final Cars cars;
    private TryCount tryCount;

    public Game(CarNames carNames, TryCount tryCount) {
        this.cars = new Cars(carNames);
        this.tryCount = tryCount;
    }

    public void race() {
        RaceResult raceResult = new RaceResult();
        MoveStrategy moveStrategy = createMoveStrategy();

        while (!tryCount.isEnd()) {
            tryCount = tryCount.decrease();
            playSingleRound(raceResult, moveStrategy);
        }

        OutputView.printRaceResult(raceResult);
    }

    private MoveStrategy createMoveStrategy() {
        return new RandomMoveStrategy(new RandomNumberGenerator());
    }

    private void playSingleRound(RaceResult raceResult, MoveStrategy moveStrategy) {
        cars.move(moveStrategy);
        raceResult.addRoundResult(cars.roundResult());
    }
}
