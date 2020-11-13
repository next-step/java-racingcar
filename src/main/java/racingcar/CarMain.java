package racingcar;

import racingcar.controller.CarController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String[] carNames = inputView.carNames();
        int tryCounts = inputView.tryCount();

        CarController carController = new CarController(carNames, tryCounts);

        outputView.resultMention();

        while(!carController.isFinish()) {
            outputView.displayCarList(carController.racing());
        }

        outputView.displayWinners(carController.getWinners());
    }
}
