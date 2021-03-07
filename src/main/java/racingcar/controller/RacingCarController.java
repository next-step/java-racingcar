package racingcar.controller;

import racingcar.model.Car;
import racingcar.module.Game;
import racingcar.module.GameManager;
import racingcar.view.InputView;

import java.util.InputMismatchException;
import java.util.List;

public class RacingCarController {

    private final InputView inputView;

    public RacingCarController() {
        this.inputView = new InputView();
    }

    public void run(){
            List<Car> carList= new GameManager().initCarGame(inputView.carNum());
            Game game = new Game(carList);
            game.startGame(inputView.tryGameNum());
    }
}
