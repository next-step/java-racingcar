package new_racingcar.controller;

import new_racingcar.domain.RoundRecord;
import new_racingcar.service.GrandPrix;
import new_racingcar.view.InputView;
import new_racingcar.view.ResultView;

import java.util.List;

public class RacingController {

    public void run() {
        InputView inputView = new InputView();
        List<String> carNames = inputView.inputNames();
        int turnCount = inputView.inputTurn();

        GrandPrix grandPrix = new GrandPrix(carNames, turnCount);
        List<RoundRecord> roundRecords = grandPrix.start();

        ResultView resultView = new ResultView();
        resultView.printGrandPrixRecords(roundRecords);
    }
}
