package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Winner;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarController {
    public void  run(){
        Cars cars = new Cars(InputView.playCarName());
        RacingGame game = new RacingGame();
        int tryNumber = InputView.tryGameNum();
        ResultView.printResultView(game.startGame(cars, tryNumber), new Winner(cars.getCars()));
    }

}
