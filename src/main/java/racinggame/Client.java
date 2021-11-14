package racinggame;

import racinggame.controller.RacingGameController;
import racinggame.view.InputView;

public class Client {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String carNames = inputView.carNames();
        String numberOfAttempts = inputView.numberOfAttempts();

        RacingGameController racingGameController = new RacingGameController();
        racingGameController.startGame(carNames, numberOfAttempts);
    }
}
