package racingcar;

import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        RacingGame racingGame = new RacingGame(inputView.getNumberOfCars(), inputView.getTryCount());
        racingGame.run();
        List<Car> cars = racingGame.getResult();

        ResultView resultView = new ResultView();
        resultView.print(cars, inputView.getTryCount());
    }
}
