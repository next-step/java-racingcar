package step5.controller;

import step5.service.Racing;
import step5.view.InputView;
import step5.view.ResultView;
import util.Message;

public class RacingController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Racing racing = new Racing(inputView.inputString(Message.INPUT_CAR_NAME), inputView.inputInt(Message.INPUT_COUNT_OF_RACE));

        resultView.carPositionPrints(racing.getCarList());
        resultView.winnerNamePrints(racing.getWinners());
    }
}
