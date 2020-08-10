package racing.controller;

import racing.domain.CarGroup;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingController {
    public void startRacing() throws Exception {
        InputView inputView = new InputView();
        CarGroup carGroup = new CarGroup(inputView.getCarNames());

        ResultView.viewResultMsg();
        for (int i = 0; i < inputView.getrepeatCount(); i++) {
            ResultView.nextRoundWithCarsStatus(carGroup);
        }
        ResultView.printVictory(carGroup.getWinnerNames());
    }
}
