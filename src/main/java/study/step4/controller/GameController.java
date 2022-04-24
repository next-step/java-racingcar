package study.step4.controller;


import study.step4.domain.Car;
import study.step4.domain.Cars;
import study.step4.domain.strategy.RandomMoveStrategy;
import study.step4.service.GameCount;
import study.step4.service.RacingGame;
import study.step4.view.InputView;
import study.step4.view.ResultView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final ResultView resultView;

    public GameController() {
        this(new InputView(), new ResultView());
    }

    public GameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    private RacingGame raceGameSetting() {
        Cars cars = carSetting();
        GameCount gameCount = gameCountSetting();

        return new RacingGame(cars, gameCount);
    }

    private Cars carSetting() {
        return new Cars(inputView.carSetting());
    }

    private GameCount gameCountSetting() {
        return new GameCount(inputView.gameCountSetting());
    }

    public void start() {
        RacingGame racingGame = raceGameSetting();

        gameplay(racingGame);
        winners(racingGame);
    }

    private void gameplay(RacingGame racingGame) {
        resultView.start();
        while (racingGame.isTerminated()) {
            resultView.printPlay(racingGame.play(new RandomMoveStrategy()));
            resultView.plintln();
        }
    }


    private void winners(RacingGame racingGame) {
        resultView.winners(racingGame.winners());
    }

}
