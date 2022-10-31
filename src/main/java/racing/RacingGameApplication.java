package racing;

import racing.domain.Cars;
import racing.domain.RacingGameInfo;
import racing.strategy.RandomMoveStrategy;
import racing.view.InputView;
import racing.view.ResultView;

import static racing.UserInputException.isValidForNumber;


public class RacingGameApplication {


    public static void main(String[] args) {
        InputView inputView = new InputView();
        Cars cars = new Cars(inputView.getCarNames());
        int tryCount = isValidForNumber(inputView.inputTryCount());

        RacingGameInfo racingGameInfo = new RacingGameInfo(cars, tryCount);
        ResultView resultView = new ResultView();

        for (int i = 0; i < tryCount; i++) {
            cars.moveEvent(new RandomMoveStrategy());
            resultView.result(cars);
        }
        resultView.printWinner(racingGameInfo.getWinners());
    }
}
