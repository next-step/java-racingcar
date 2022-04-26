package study.step4.controller;


import study.step4.domain.Cars;
import study.step4.domain.strategy.RandomMoveStrategy;
import study.step4.service.GameCount;
import study.step4.service.RacingGame;
import study.step4.view.InputView;
import study.step4.view.ResultView;

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

    public void start() {
        RacingGame racingGame = raceGameSetting();

        gameplay(racingGame, new RandomMoveStrategy());
        winners(racingGame);
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

    private void gameplay(RacingGame racingGame, RandomMoveStrategy randomMoveStrategy) {
        resultView.start();
        while (racingGame.isTerminated()) {
            resultView.printPlay(racingGame.play(randomMoveStrategy));
            resultView.plintln();
        }
    }


    private void winners(RacingGame racingGame) {
        resultView.winners(racingGame.winners());
    }

}
