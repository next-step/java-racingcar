package car.service;

import car.domain.Cars;
import car.domain.RacingGame;
import car.domain.strategy.RandomRacingGameStrategyImpl;
import car.ui.GameResult;
import car.ui.Winner;

import java.util.List;

public class RacingGameService {

    public GameResult<List<Winner>> start(String carNames, int moveCount) {
        Cars cars = Cars.of(carNames);
        RacingGame racingGame = new RacingGame(new RandomRacingGameStrategyImpl(), cars);
        return racingGame.play(moveCount);
    }
}
