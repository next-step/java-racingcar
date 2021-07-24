package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingCarController racingCarController = new RacingCarController();

        String[] carNames = inputView.insertCarNames();
        int tryNumber = inputView.getNumberOfTry();

        List<Car> winners = racingCarController.getWinner(carNames, tryNumber);

        resultView.getWinner(winners);
    }
}
