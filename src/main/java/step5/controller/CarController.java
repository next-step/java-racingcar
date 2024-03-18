package step5.controller;

import step5.domain.Racing;
import step5.view.InputRequest;
import step5.view.InputView;
import step5.view.ResultView;

public class CarController {


    public void startGame() {
        InputRequest inputRequest = InputView.createInputRequest();
        ResultView resultView = new ResultView(Racing.createRacing(inputRequest.getCarNames(), inputRequest.getTryNumber()));
        resultView.startGame();
    }
}
