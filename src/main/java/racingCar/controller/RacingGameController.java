package racingCar.controller;

import racingCar.domain.Cars;
import racingCar.domain.RacingGame;
import racingCar.view.InputView;
import racingCar.view.ResultView;

import java.util.List;

public class RacingGameController {

    public void initiate() {
        String carName = InputView.textInputCarNameSeparateOfComma();
        int moveCount = InputView.chanceCarMoveCount();
        Cars cars = new Cars(carName);

        RacingGame racingGame = new RacingGame(cars);
        List<Cars> result = racingGame.execute(moveCount);

        ResultView.print(result);
        ResultView.printWinner(racingGame.getWinners());
    }
}
