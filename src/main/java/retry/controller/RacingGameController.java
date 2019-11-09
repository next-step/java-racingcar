package retry.controller;

import retry.view.InputView;

public class RacingGameController {

    public void initiate() {
        String carName = InputView.textInputCarNameSeparateOfComma();
        int moveCount = InputView.chanceCarMoveCount();

    }
}
