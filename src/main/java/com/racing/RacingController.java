package com.racing;

import com.racing.game.view.InputView;
import com.racing.game.viewmodel.InputViewModel;

public class RacingController {
    private InputViewModel inputViewModel;

    public RacingController(InputViewModel inputViewModel) {
        this.inputViewModel = inputViewModel;
    }

    public void startRace() {
        InputView inputView = new InputView(inputViewModel);
        inputView.drawCarCountInputView();
        inputView.drawTryCountInputView();
    }
}
