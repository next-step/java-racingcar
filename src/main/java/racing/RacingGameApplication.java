package racing;

import racing.domain.Cars;
import racing.strategy.RandomMoveStrategy;
import racing.view.InputView;
import racing.view.ResultView;


public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Cars cars = new Cars(inputView.getCarNames());
        int tryCount = inputView.getTryCount();

        for (int i = 0; i < tryCount; i++) {
            cars.move(new RandomMoveStrategy());
            resultView.result(cars);
        }

        resultView.printWinner(cars.getWinners());
    }
}
