package racingcar.controller;

import racingcar.model.Car;
import racingcar.module.Game;
import racingcar.module.GameManager;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarController {

    private final InputView inputView;
    private final Game game;

    public RacingCarController() {
        this.inputView = new InputView();
        this.game = new Game();
    }

    public void run(){
        List<Car> carList= new GameManager().initCarGame(inputView.carNum());
        game.playCarGame(carList, inputView.tryGameNum());
    }
}
