package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.module.RacingGame;
import racingcar.module.GameManager;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarController {

    private final InputView inputView;
    private final ResultView resultView;
    public RacingCarController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
            Cars cars= new GameManager().countOfRound(inputView.carNum());
            RacingGame game = new RacingGame(cars);
            int tryNumber = inputView.tryGameNum();
            game.startGame(tryNumber);
            resultView.printResultView(tryNumber,cars);
    }
}
