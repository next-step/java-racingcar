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
        Cars cars = new Cars(inputView.inputCarNames());
        RacingGame racingGame = new RacingGame(cars, inputView.inputTryCount(),new RandomStrategy());
        RaceResults raceResults = racingGame.startRace();
        outputView.printResult(raceResults);
        outputView.printWinner(raceResults.findWinners());
    }
}
