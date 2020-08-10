package racing.controller;

import racing.domain.CarGroup;
import racing.view.InputView;

public class RacingController {
    public void startRacing() throws Exception {
        InputView inputView = new InputView();
        CarGroup carGroup = new CarGroup(inputView.getCarNames());
        carGroup.print(inputView.getrepeatCount());
    }
}
