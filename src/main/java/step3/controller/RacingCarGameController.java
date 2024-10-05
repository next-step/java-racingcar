package step3.controller;

import step3.service.CarEngine;
import step3.service.RacingCarGame;
import step3.service.RandomEngine;
import step3.view.InputView;

public class RacingCarGameController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.receiveAndViewAndValidate();

        CarEngine carEngine = new RandomEngine();
        RacingCarGame racingCarGame = new RacingCarGame(carEngine);

        racingCarGame.execute(inputView.getCarNameArray(), inputView.getRound());
    }
}
