package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.MoveStrategy;
import racingcar.model.RaceResults;
import racingcar.model.RacingGame;
import racingcar.model.RandomStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    public void play() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MoveStrategy moveStrategy = new RandomStrategy();
        Cars cars = new Cars(inputView.inputCarNames(), moveStrategy);
        RacingGame racingGame = new RacingGame(cars, inputView.inputTryCount());
        RaceResults raceResults = new RaceResults(racingGame.startRace());
        outputView.printResult(raceResults);
        outputView.printWinner(raceResults.findWinners());
    }
}
