package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.view.InputView;

public class RacingGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingCarController racingCarController = new RacingCarController();

        String[] carNames = inputView.insertCarNames();
        int tryNumber = inputView.getNumberOfTry();

        racingCarController.getWinner(carNames, tryNumber);
    }
}
