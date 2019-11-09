package retry.controller;

import retry.domain.Cars;
import retry.domain.RacingGame;
import retry.view.InputView;
import retry.view.ResultView;

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
